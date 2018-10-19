package edu.miracosta.cs113.printerQueue;
/**
 * Job : This class represents a job. It has a number of pages associated with it along with
 * a state of completion and durration.
 */
public class Job
{
    /**
     *   @param numberOfPages The length of the job.
     *   @param timeTakenToComplete The time that it takes to complete the job
     *   @param jobCompleted True if job is completed.
     *   @param jobId The id that is assigned to the job when created.These id's will increase as more jobs are created.
     *   @param printerId The id of the printer responsible for printing the job.
     *   @param pagesLeft The number of pages left to print.
     */
    int jobId;
    int numberOfPages;
    int timeTakenToComplete;
    int pagesLeft;
    int printerId;
    boolean jobCompleted;

    public Job(int numberOfPages,  int JobId)
    {
        this.numberOfPages = numberOfPages;
        timeTakenToComplete = 0;
        jobCompleted = false;
        jobId = JobId;
        pagesLeft = numberOfPages;
        printerId = 0;

    }

    /***************************************************************
     * Returns the number of pages in the job.
     ***************************************************************/
    public int getNumberOfPages()
    {
        return numberOfPages;
    }

    /***************************************************************
     * Tells if the printer is out of pages.
     ***************************************************************/
    public boolean outOfPages()
    {
        return (pagesLeft == 0);
    }

    /***************************************************************
     * Displays the number of pages left.
     ***************************************************************/
    public int getPagesLeft()
    {
        return pagesLeft;
    }

    /***************************************************************
     * sets number of pages in the job.
     ***************************************************************/
    public void setNumberOfPages(int numberOfPages)
    {
        this.numberOfPages = numberOfPages;
    }

    /***************************************************************
     * Removes one page from the job.
     ***************************************************************/
    public void removeApage()
    {
        pagesLeft = pagesLeft - 1;
    }

    /***************************************************************
     * returns the time taken to complete the job.
     ***************************************************************/
    public int getTimeTakenToComplete()
    {
        return timeTakenToComplete;
    }

    /***************************************************************
     * sets the time taken to complete the job.
     ***************************************************************/

    public void setTimeTakenToComplete(int timeTakenToComplete)
    {
        this.timeTakenToComplete = timeTakenToComplete;
    }

    /***************************************************************
     * sets the state of the job.
     ***************************************************************/
    public void setJobCompleted(boolean jobCompleted)
    {
        this.jobCompleted = jobCompleted;
    }

    /***************************************************************
     * Gets the job id.
     ***************************************************************/
    public int getJobId()
    {
        return jobId;
    }

    /***************************************************************
     * Sets the id of the printer that is to print the page.
     ***************************************************************/
    public void setPrinterId(int printerId)
    {
        this.printerId = printerId;
    }

    /***************************************************************
     *gets the id of the printer that is to print the page.
     ***************************************************************/
    public int getPrinterId()
    {
        return printerId;
    }
    /***************************************************************
     * Returns true if job is completed and false if not.
     ***************************************************************/
    public boolean isJobCompleted()
    {
        return jobCompleted;
    }

    /***************************************************************
     * Returns string that says true if job is completed, the number
     * of pages left, and the time taken to complete.
     ***************************************************************/
    @Override
    public String toString()
    {
        return ("[Job id:" + jobId +"] [Number of pages :" + numberOfPages + "] [Time taken to complete:" + timeTakenToComplete + "] [Completed:"+ jobCompleted+"]" + " [printed by printer:" + printerId +"]");
    }
}