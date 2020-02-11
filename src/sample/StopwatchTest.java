package sample;

import org.junit.After;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StopwatchTest
{
    private Stopwatch stopwatch;

    @Before
    public void setUp() throws Exception
    {
        stopwatch=new Stopwatch(10);
    }

    @org.junit.Test
    public void getLaps()
    {
        assertEquals(0,stopwatch.getLaps());
    }

    @org.junit.Test
    public void getSeconds()
    {
        assertThat(0.0,is(stopwatch.getSeconds()));
    }

    @org.junit.Test
    public void getMinutes()
    {
        assertEquals(0,stopwatch.getMinutes());
    }

    @org.junit.Test
    public void getHours()
    {
        assertEquals(0,stopwatch.getHours());
    }

    @After
    public void tearDown() throws Exception
    {
        stopwatch=null;
    }
}