package edu.miracosta.cs113.printerQueue;
/**
 * Printer : Class that handles the jobs and process them. Will be responsible for
 * displaying how much of the job is completed.
 */
public class Printer
{
    /**
     *   @param maxPagesPerMinute max ammount of pages the printer will accept per job.
     *   @param minPagePerMinute min ammount of pages the printer will accept per job.
     *   @param pagesPerMinute The pages that the printer prints per minut.
     */
    int maxPages;
    int minPage;
    int pagesPerMinute;

    Printer(int ppm, int thisMaxallowedPages, int thisMinPagePerMinute)
    {
        pagesPerMinute = ppm;
        maxPages = thisMaxallowedPages;
        minPages = thisMinPagePerMinute;
    }

    /***************************************************************
     * Returns max pages allowed per job.
     ***************************************************************/
    public int getMaxPages()
    {
        return maxPages;
    }

    /***************************************************************
     * sets max pages allowed per job.
     ***************************************************************/

    public void setMaxPages(int maxPages)
    {
        this.maxPages = maxPages;
    }

    /***************************************************************
     * Returns min pages allowed per job.
     ***************************************************************/

    public int getMinPage()
    {
        return minPage;
    }

    /***************************************************************
     * sets min pages allowed per job.
     ***************************************************************/
    public void setMinPage(int minPage)
    {
        this.minPage = minPage;
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
