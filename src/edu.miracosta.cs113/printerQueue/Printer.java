package edu.miracosta.cs113.printerQueue;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Printer : Class that handles the jobs and process them. Will be responsible for
 * displaying how much of the job is completed.
 */
public class Printer
{
    /**
     *   @param jobBeingProcessed The current page being processed.
     *   @param totalTimeToComplete The total time the job took to complete.
     *   @param pagesPerMinute The pages that the printer prints per minute.
     *   @param second This is suppose to tell us what second we are on.
     *   @param jobsInQue This is the jobs sent to this printer thus far.
     */

    private int pagesPerMinute;
    private int second;
    private Queue<Job> jobsInQue;
    private static Queue<Job> jobsCompleted;
    private Job jobBeingProcessed;
    private int totalTimeToComplete;
    private boolean busy;
    private int printerId;


    public Printer(int ppm, int thisPrinterId)
    {
        pagesPerMinute = ppm;
        second = 0;
        jobsInQue = new LinkedList<>();
        jobsCompleted = new LinkedList<>();
        jobBeingProcessed = null;
        busy = false;
        printerId = thisPrinterId;
    }

    /***************************************************************
     * Adds a job to the que.
     ***************************************************************/
     public void addAJob(Job newJob)
     {
         newJob.setPrinterId(printerId);
         jobsInQue.add(newJob);
         System.out.println("The following job was added: " + newJob);
     }


    /***************************************************************
     * Increments clock by a second.
     ***************************************************************/
    public int aSecondHasPassed()
    {
        //If the que is not empty.
        if(!jobsInQue.isEmpty())
        {
            busy = true;
            second = second+1;
            totalTimeToComplete = totalTimeToComplete+1;

            //If the job being procecced is empty.
            if(jobBeingProcessed == null)
            {
                jobBeingProcessed = jobsInQue.peek();

            }
            //process the job.
            if(second == (60/pagesPerMinute))
            {
                //remove a page every 6 seconds.
                jobBeingProcessed.removeApage();
                second = 0;
                //if the job is out of pages.
                if(jobBeingProcessed.outOfPages())
                {
                    jobBeingProcessed.setJobCompleted(true);
                    jobBeingProcessed.setTimeTakenToComplete(totalTimeToComplete);
                    jobsCompleted.add(jobBeingProcessed);
                    jobBeingProcessed = null;
                    jobsInQue.poll();
                    totalTimeToComplete = 0;
                }
            }
        }
        else
        {
            busy = false;
            return 0;
        }
         return second;
    }

    /***************************************************************
     * Prints jobs completed.
     ***************************************************************/
    public void printJobsCompleted()
    {
        while (!jobsCompleted.isEmpty())
        {
            System.out.println(jobsCompleted.poll().toString());
        }
        System.out.println("The above are displayed in order of completion.");
        System.out.println("The Job id corresponds to the order in which the jobs were received by the printer: ");
    }

    /***************************************************************
     * Determines if the printer is working. Returns true if it is.
     ***************************************************************/
    public boolean isBusy()
    {
        return busy;
    }

    /***************************************************************
     * Returns the jobs completed.
     ***************************************************************/
    public static Queue<Job> getJobsCompleted()
    {
        return jobsCompleted;
    }

    /***************************************************************
     *sets the linkedlist of jobs completed.
     ***************************************************************/
    public static void setJobsCompleted(Queue<Job> jobsCompleted)
    {
        Printer.jobsCompleted = jobsCompleted;
    }

    /***************************************************************
     * Returns the amount of seconds the printer has been alive for.
     ***************************************************************/
    public int getSecond()
    {
        return second;
    }

    /***************************************************************
     * sets the amount of seconds the printer has been alive for.
     ***************************************************************/
    public void setSecond(int second)
    {
        this.second = second;
    }
    /***************************************************************
     * Returns ppm of printer.
     ***************************************************************/
    public int getPagesPerMinute()
    {
        return pagesPerMinute;
    }

    /***************************************************************
     *sets ppm of printer.
     ***************************************************************/
    public void setPagesPerMinute(int pagesPerMinute)
    {
        this.pagesPerMinute = pagesPerMinute;
    }
}
