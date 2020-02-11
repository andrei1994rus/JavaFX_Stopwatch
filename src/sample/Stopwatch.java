package sample;

import java.util.concurrent.TimeUnit;

/**
 * Class Stopwatch is used for work of Stopwatch.
 * Interface Runnable is used for work of thread.
 */
public class Stopwatch implements Runnable
{
    /**
     * Number of ticks.
     */
    private long ticks;

    /**
     * Time interval (in milliseconds) of tick.
     */
    private int interval;

    /**
     * Object of class Controller. Is used for update of time in lTime.
     */
    private Controller gui;

    /**
     * Thread which causes ticks. If is null stopwatch isn't running.
     */
    private Thread thread;

    /**
     * Number of laps.
     */
    private int laps=0;

    /**
     * Constructor of class Stopwatch. Sets interval.
     *
     * @param interval
     *               time interval (in milliseconds) of stopwatch.
     *
     */
    Stopwatch(int interval)
    {
        this.interval=interval;
    }

    /**
     * Attaches gui to timer.
     *
     * @param gui
     *           object of class Controller. Is used to attach to stopwatch.
     *
     */
    public final void attach(Controller gui)
    {
        this.gui=gui;
    }

    /**
     * Gets laps.
     *
     * @return number of laps.
     *
     */
    public final int getLaps()
    {
        return laps;
    }

    /**
     * Gets seconds.
     *
     * @return number of seconds.
     *
     */
    public final double getSeconds()
    {
        return (ticks*interval)/1000.0%60;
    }

    /**
     * Gets minutes.
     *
     * @return number of minutes.
     *
     */
    public final long getMinutes()
    {
        return TimeUnit.MILLISECONDS.toMinutes(ticks*interval)%60;
    }

    /**
     * Gets hours.
     *
     * @return number of hours.
     *
     */
    public final long getHours()
    {
        return TimeUnit.MILLISECONDS.toHours(ticks*interval);
    }

    /**
     * Starts stopwatch.
     */
    public final void start()
    {
        if(thread==null)
        {
            thread=new Thread(this);
            thread.setDaemon(true);
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();

            gui.update();
        }
    }

    /**
     * Pauses stopwatch.
     */
    public final void pause()
    {
        if(thread!=null)
        {
            thread=null;
        }

        gui.update();
    }

    /**
     * Resets time and laps.
     */
    public final void reset()
    {
        ticks=0;

        laps=0;

        gui.update();
    }

    /**
     * Increments ticks after expiration of time interval.
     */
    @Override
    public final void run()
    {
        while(thread!=null)
        {
            try
            {
                Thread.sleep(interval);
            }

            catch(InterruptedException e)
            {
                e.printStackTrace();
            }

            if(thread!=null)
            {
                ticks++;

                gui.update();
            }
        }
    }

    /**
     * Outputs time of passed lap to lTime and does new lap.
     */
    public void newLap()
    {
        laps++;

        gui.outputTimeOfLaps();

        ticks=0;
    }
}
