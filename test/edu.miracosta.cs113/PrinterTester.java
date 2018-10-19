package edu.miracosta.cs113;

import edu.miracosta.cs113.change.ChangeCalculator;
import edu.miracosta.cs113.printerQueue.Job;
import edu.miracosta.cs113.printerQueue.RandomPageGenerator;
import edu.miracosta.cs113.printerQueue.Printer;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * ChangeCalculatorTest : Tester class for demonstrating class ChangeCalculator's recursive method
 * calculateChange(int), which determines and prints all possible coin combinations representing a given monetary
 * value in cents.
 */
public class PrinterTester
{
    /** Number of pages for the job. */
    private static final int[] numberOfPagesForJob = { 5, 10, 15, 20, 25, 30 };

    /** Number of pages for the job. */
    private static final int[] timeEachJobShouldTakeToCompleteInSeconds= { 30, 60, 90, 120, 150, 180 };

    /** job id for the job */
    private static final int[] jobIdForJob = { 1, 2, 3, 4, 5, 6 };

    /** Random page generator max value*/
    private static final int[] maxValueForRandomPageGenerator= { 5, 10, 15, 20, 25, 30 };


    //test the number of pages per job.
    @Test
    public void testNumberOfPagesPerJob()
    {
        for(int i = 0; i < numberOfPagesForJob.length; i++)
        {
            Job testJob = new Job(numberOfPagesForJob[i], 0);

            assertEquals(testJob.getNumberOfPages(), numberOfPagesForJob[i]);
        }

    }

    @Test
    public void testDecrementingJobByOne()
    {
        //checks the decrement by 1 method and out of pages method.

        for(int c = 0; c < numberOfPagesForJob.length; c++)
        {
            Job testJob = new Job(numberOfPagesForJob[c], 0);

            for (int i = 0; i < numberOfPagesForJob[c]; i++)
            {
                testJob.removeApage();
            }
            assertEquals(testJob.outOfPages(), true);
        }


    }

    //test to see of the jobs are completed in the expected amount of time.
    @Test
    public void testPrinterFunction()
    {
        Printer testPrinter = new Printer(10, 10000);

        for(int c = 0; c < numberOfPagesForJob.length; c++)
        {
            Job testJob = new Job(numberOfPagesForJob[c], 0);
            testPrinter.addAJob(testJob);

            for(int i = 0; i <= timeEachJobShouldTakeToCompleteInSeconds[c]; i++)
            {
                testPrinter.aSecondHasPassed();
            }

            assertEquals(testPrinter.isBusy(), false);
        }
    }

    //test to see of the jobs are completed in the expected amount of time.
    @Test
    public void testPrinterFunctionBulk()
    {
        Printer testPrinter = new Printer(10, 10000);
        int totalTime = 0;
        for(int c = 0; c < numberOfPagesForJob.length; c++)
        {
            Job testJob = new Job(numberOfPagesForJob[c], 0);
            testPrinter.addAJob(testJob);
            totalTime += timeEachJobShouldTakeToCompleteInSeconds[c];
        }

        for(int i = 0; i <= totalTime; i++)
        {
            testPrinter.aSecondHasPassed();
        }

        assertEquals(testPrinter.isBusy(), false);
    }

}

