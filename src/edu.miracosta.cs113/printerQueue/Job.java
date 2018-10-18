package edu.miracosta.cs113.printerQueue;
/**
 * Job : This class represents a job. It has a number of pages associated with it along with
 * a state of completion and durration.
 */
class Job
{
    /**
     *   @param numberOfPages The length of the job.
     *   @param timeTakenToComplete The time that it takes to complete the job
     *   @param jobCompleted True if job is completed.
     */
    int jobId;
    int numberOfPages;
    int timeTakenToComplete;
    int pagesLeft;
    boolean jobCompleted;

    Job(int numberOfPages,  int JobId)
    {
        this.numberOfPages = numberOfPages;
        timeTakenToComplete = 0;
        jobCompleted = false;
        jobId = JobId;
        pagesLeft = numberOfPages;

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
        return ("[Job id:" + jobId +"] [Number of pages :" + numberOfPages + "] [Time taken to complete:" + timeTakenToComplete + "] [Completed:"+ jobCompleted+"]");
    }
}