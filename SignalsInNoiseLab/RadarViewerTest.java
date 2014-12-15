

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RadarViewerTest.
 *
 * @author  Rob Norton
 * @version 14 December 2014
 */
public class RadarViewerTest
{
    /**
     * Default constructor for test class RadarViewerTest
     */
    public RadarViewerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    /**
     * Test for dx of 1 and dy of 2
     */
    public void test1() throws InterruptedException
    {
        RadarViewer radar = new RadarViewer(1,2);
        assertEquals("DX should be 1", 1, radar.getRadarDX());
        assertEquals("DY should be 2", 2, radar.getRadarDY());
    }
    
    @Test
    /**
     * Test for dx of 5 and dy of 3
     */
    public void test2() throws InterruptedException
    {
        RadarViewer radar = new RadarViewer(5,3);
        assertEquals("DX should be 5", 5, radar.getRadarDX());
        assertEquals("DY should be 3", 3, radar.getRadarDY());
    }
    
    @Test
    /**
     * Test for dx of 3 and dy of 3
     */
    public void test3() throws InterruptedException
    {
        RadarViewer radar = new RadarViewer(3,3);
        assertEquals("DX should be 3", 3, radar.getRadarDX());
        assertEquals("DY should be 3", 3, radar.getRadarDY());
    }
}
