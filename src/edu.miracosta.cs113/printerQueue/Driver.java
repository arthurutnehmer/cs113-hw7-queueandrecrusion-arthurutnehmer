package edu.miracosta.cs113.printerQueue;

public class Driver
{
    public static void main(String[]args)
    {
        //Create printers.
        //printer 10 is for 10 pages and less.
        Printer testPrinter010 = new Printer(10,10);
        //printer 1020 is for 10 to 20 pages.
        Printer testPrinter1020 = new Printer(10,1020);
        //printer 2050 is for 20 to 50 pages.
        Printer testPrinter2050 = new Printer(10,2050);

        //Create counter.
        int totalSeconds = 0;
        int totalJobs = 0;
        //create a random page generator.
       RandomPageGenerator test = new RandomPageGenerator(50);


        while (true)
        {
            try
            {
                //add to the que every 100 seconds depenging on the page count.
                if( ((totalSeconds%100) == 0) && totalJobs < 100)
                {
                    Job newJob = test.generateARandomJob();
                    int pageCount = newJob.getNumberOfPages();

                    //setup the distribution.
                    if(pageCount < 10)
                    {
                        testPrinter010.addAJob(newJob);
                        totalJobs++;
                    }
                    else if(pageCount <= 20)
                    {
                        testPrinter1020.addAJob(newJob);
                        totalJobs++;
                    }
                    else if(pageCount <= 50)
                    {
                        testPrinter2050.addAJob(newJob);
                        totalJobs++;
                    }
                }

                //Iterate the time of each printer by one second. The thread.sleep can be lowered to speed up the simulation.
                Thread.sleep(1);
                totalSeconds++;

                testPrinter010.aSecondHasPassed();
                testPrinter1020.aSecondHasPassed();
                testPrinter2050.aSecondHasPassed();

                //If all of the printers are not busy, then print the stack of completed jobs.
                if( (!testPrinter010.isBusy()) && (!testPrinter1020.isBusy()) && (!testPrinter2050.isBusy()) && (totalJobs == 100))
                {
                    System.out.println( "-------------------------------------------------------------------");
                    testPrinter010.printJobsCompleted();
                    System.out.println("All " + totalJobs +" jobs took: " + totalSeconds/60 + " minutes.");
                    System.out.println( "-------------------------------------------------------------------");
                    break;
                }
            }
            catch (InterruptedException e)
            {
                // We've been interrupted: no more messages.
                return;
            }

        }



    }

}
