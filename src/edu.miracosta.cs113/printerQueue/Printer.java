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
    private Job jobBeingProcessed;
    private int totalTimeToComplete;


    Printer(int ppm)
    {
        pagesPerMinute = ppm;
        second = 0;
        jobsInQue = new LinkedList<>();
        jobBeingProcessed = null;
    }

    /***************************************************************
     * Adds a job to the que.
     ***************************************************************/
     public void addAJob(Job newJob)
     {
         jobsInQue.add(newJob);
     }


    /***************************************************************
     * Increments clock by a second.
     ***************************************************************/
    public int aSecondHasPassed()
    {
        //If the que is not empty.
        if(!jobsInQue.isEmpty())
        {
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
                    System.out.println(jobBeingProcessed);
                    jobBeingProcessed = null;
                    jobsInQue.poll();
                    totalTimeToComplete = 0;
                }
            }
        }
        else
        {
            return 0;
        }
         return second;
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
