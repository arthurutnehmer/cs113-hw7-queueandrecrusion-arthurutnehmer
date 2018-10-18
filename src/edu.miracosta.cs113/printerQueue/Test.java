package edu.miracosta.cs113.printerQueue;

public class Test
{
    public static void main(String[]args)
    {
        Job testJob = new Job(3, 1);
        Job testJob2 = new Job(5, 2);
        Job testJob3 = new Job(3, 3);

        Printer testPrinter = new Printer(10);
        Printer testPrinter2 = new Printer(10);
        Printer testPrinter3 = new Printer(10);

        testPrinter.addAJob(testJob);
        testPrinter2.addAJob(testJob2);
        testPrinter3.addAJob(testJob3);

        while (true)
        {
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                // We've been interrupted: no more messages.
                return;
            }
            testPrinter.aSecondHasPassed();
            testPrinter2.aSecondHasPassed();
            testPrinter3.aSecondHasPassed();

        }



    }

}
