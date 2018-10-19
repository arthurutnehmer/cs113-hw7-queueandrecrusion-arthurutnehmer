package edu.miracosta.cs113.printerQueue;
import java.util.Random;
/**
 * RandomPageGenerator : This class generates random jobs.
 */
public class RandomPageGenerator
{
    /**
     *   @param second -what second the iteration is on.
     */
    int second;
    int jobNumber;
    Job jobToBeGiven;
    int maxPages;
    RandomPageGenerator(int thisMaxPages)
    {
        second = 0;
        jobNumber = 0;
        maxPages = thisMaxPages;
    }

    /***************************************************************
     * Creates a random job.
     ***************************************************************/
    public Job generateARandomJob()
    {
        jobNumber = jobNumber+1;
        //create a random number of pages.
        Random rand = new Random();
        int  numberOfPages = rand.nextInt(maxPages) + 1;

        //initiate a random job.
        Job tempJob = new Job(numberOfPages, jobNumber);
        return tempJob;

    }

    /***************************************************************
     * Creates a random job every 100 seconds.
     ***************************************************************/
    public Job aSecondHasPassed()
    {
        second = second+1;
        if(second == 100)
        {
            second = 0;
            jobToBeGiven = generateARandomJob();
            return jobToBeGiven;
        }
        else
        {
            return null;
        }
    }

}
