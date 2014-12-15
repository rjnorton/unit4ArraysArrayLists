import javax.swing.JFrame;

/**
 * Class that contains the main method for the program and creates the frame containing the component.
 * 
 * @author @Rob Norton
 * @version 14 December 2014
 */
public class RadarViewer
{
    private int ROWS;
    private int COLS;
    private int DX;
    private int DY;
    private int radarDX;
    private int radarDY;
    /**
     * Constructor
     *
     * @param    dx    the change in x of the monster
     * @param    dy    the change in y of the monster
     */
    public RadarViewer(int dx, int dy) throws InterruptedException
    {
        ROWS = 100;
        COLS = 100;
        DX = dx;
        DY = dy;
        Radar radar = new Radar(ROWS, COLS);
        radar.setNoiseFraction(0.003);
        radar.scan();
        radar.updateAccumulator();
        
        JFrame frame = new JFrame();
        
        frame.setTitle("Signals in Noise Lab");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // a frame contains a single component; create the radar component and add it to the frame
        RadarComponent component = new RadarComponent(radar);
        frame.add(component);
        
        // set the size of the frame to encompass the contained component
        frame.pack();
        
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);
        
        // perform 100 scans of the radar wiht a slight pause between each
        // after each scan, instruct the Java Run-Time to redraw the window
        for(int i = 0; i < 100; i++)
        {
            Thread.sleep(100); // sleep 100 milliseconds (1/10 second)
            
            if (((DX*i) >= 100)||((DY*i) >= 100))
            {
                break;
            }
            
            radar.scan();
            radar.setMonsterLocation(DX*i,DY*i);
            radar.updateAccumulator();
            radar.checkDyDx();
            
            frame.repaint();
        }
        
        //Get the dydx with the highest number of hits (hopefully monster but sometimes noise gets more)
        int[] dydx = radar.getDyDx();
        radarDX = dydx[0];
        radarDY = dydx[1];
    }
    
    public int getRadarDX()
    {
        return radarDX;
    }
    
    public int getRadarDY()
    {
        return radarDY;
    }
    
    /**
     * main method for the program which creates and configures the frame for the program
     *
     */
    public static void main(int[] args) throws InterruptedException
    {
        // create the radar, set the monster location, and perform the initial scan
        final int ROWS = 100;
        final int COLS = 100;
        final int DX = args[0];
        final int DY = args[1];
        Radar radar = new Radar(ROWS, COLS);
        radar.setNoiseFraction(0.001);
        radar.scan();
        radar.updateAccumulator();
        
        JFrame frame = new JFrame();
        
        frame.setTitle("Signals in Noise Lab");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // a frame contains a single component; create the radar component and add it to the frame
        RadarComponent component = new RadarComponent(radar);
        frame.add(component);
        
        // set the size of the frame to encompass the contained component
        frame.pack();
        
        // make the frame visible which will result in the paintComponent method being invoked on the
        //  component.
        frame.setVisible(true);
        
        // perform 100 scans of the radar wiht a slight pause between each
        // after each scan, instruct the Java Run-Time to redraw the window
        for(int i = 0; i < 100; i++)
        {
            Thread.sleep(100); // sleep 100 milliseconds (1/10 second)
            
            if (((DX*i) >= 100)||((DY*i) >= 100))
            {
                break;
            }
            
            radar.scan();
            radar.setMonsterLocation(DX*i,DY*i);
            radar.updateAccumulator();
            radar.checkDyDx();
            
            frame.repaint();
        }
        
        //Get the dydx with the highest number of hits
        int[] dydx = radar.getDyDx();
        
        System.out.println("The monster had a dx of: "+dydx[0]+" and a dy of:"+dydx[1]);
    }
    
}
