
/**
 * The model for radar scan and accumulator
 * 
 * @author @Rob Norton
 * @version 14 December 2014
 */
public class Radar
{
    
    // stores whether each cell triggered detection for the current scan of the radar
    private boolean[][] currentScan;
    private boolean[][] prevScan;
    
    private int[][] dydx;
    // value of each cell is incremented for each scan in which that cell triggers detection 
    private int[][] accumulator;
    
    // location of the monster
    private int monsterLocationRow;
    private int monsterLocationCol;
    
    // Change in x and y
    private int dx;
    private int dy;

    // probability that a cell will trigger a false detection (must be >= 0 and < 1)
    private double noiseFraction;
    
    // number of scans of the radar since construction
    private int numScans;

    /**
     * Constructor for objects of class Radar
     * 
     * @param   rows    the number of rows in the radar grid
     * @param   cols    the number of columns in the radar grid
     */
    public Radar(int rows, int cols)
    {
        // initialize instance variables
        currentScan = new boolean[rows][cols]; // elements will be set to false
        prevScan = new boolean[rows][cols];
        accumulator = new int[rows][cols]; // elements will be set to 0
        dydx = new int[36][3];
        int j = 0;
        
        //creates an array of all possible dx and dy combinations
        for (int i = 0; i<= 35; i++)
        {
            dydx[i][0] = j;
            j++;
            if ((j%6) == 0){j=0;}
            if (i >= 0){dydx[i][1] = 0;}
            if (i > 5){dydx[i][1] = 1;}
            if (i >= 12){dydx[i][1] = 2;}
            if (i >= 18){dydx[i][1] = 3;}
            if (i >= 24){dydx[i][1] = 4;}
            if (i >= 30){dydx[i][1] = 5;}
            dydx[i][2] = 0;
        }
        
        // randomly set the location of the monster (can be explicity set through the
        //  setMonsterLocation method
        monsterLocationRow = (int)(Math.random() * rows);
        monsterLocationCol = (int)(Math.random() * cols);
        currentScan[monsterLocationRow][monsterLocationCol] = true;
        noiseFraction = 0.05;
        numScans= 0;
    }
    
    /**
     * Performs a scan of the radar. Noise is injected into the grid and the accumulator is updated.
     * 
     */
    public void scan()
    {
        // set prevScan equal to currentScan
        for (int row = 0; row < currentScan.length; row++)
        {
            for (int col = 0; col < currentScan[0].length; col++)
            {
                prevScan[row][col] = currentScan[row][col];
            }
        }
        //zero the current scan
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                currentScan[row][col] = false;
            }
        }

        // inject noise into the grid
        injectNoise();
    }
    
    public void updateAccumulator()
    {
        // udpate the accumulator
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                if(currentScan[row][col] == true)
                {
                   accumulator[row][col]++;
                }
            }
        }
        
        // keep track of the total number of scans
        numScans++;
    }

    /**
     * Sets the location of the monster
     * 
     * @param   row     the row in which the monster is located
     * @param   col     the column in which the monster is located
     * @pre row and col must be within the bounds of the radar grid
     */
    public void setMonsterLocation(int row, int col)
    {
        // remember the row and col of the monster's location
        monsterLocationRow = row;
        monsterLocationCol = col;
        
        // update the radar grid to show that something was detected at the specified location
        currentScan[row][col] = true;
    }
    
     /**
     * Sets the probability that a given cell will generate a false detection
     * 
     * @param   fraction    the probability that a given cell will generate a flase detection expressed
     *                      as a fraction (must be >= 0 and < 1)
     */
    public void setNoiseFraction(double fraction)
    {
        noiseFraction = fraction;
    }
    
    /**
     * Returns true if the specified location in the radar grid triggered a detection.
     * 
     * @param   row     the row of the location to query for detection
     * @param   col     the column of the location to query for detection
     * @return true if the specified location in the radar grid triggered a detection
     */
    public boolean isDetected(int row, int col)
    {
        return currentScan[row][col];
    }
    
    /**
     * Returns the number of times that the specified location in the radar grid has triggered a
     *  detection since the constructor of the radar object.
     * 
     * @param   row     the row of the location to query for accumulated detections
     * @param   col     the column of the location to query for accumulated detections
     * @return the number of times that the specified location in the radar grid has
     *          triggered a detection since the constructor of the radar object
     */
    public int getAccumulatedDetection(int row, int col)
    {
        return accumulator[row][col];
    }
    
    /**
     * Returns the number of rows in the radar grid
     * 
     * @return the number of rows in the radar grid
     */
    public int getNumRows()
    {
        return currentScan.length;
    }
    
    /**
     * Returns the number of columns in the radar grid
     * 
     * @return the number of columns in the radar grid
     */
    public int getNumCols()
    {
        return currentScan[0].length;
    }
    
    /**
     * Returns the number of scans that have been performed since the radar object was constructed
     * 
     * @return the number of scans that have been performed since the radar object was constructed
     */
    public int getNumScans()
    {
        return numScans;
    }
    
    /**
     * Sets cells as falsely triggering detection based on the specified probability
     * 
     */
    private void injectNoise()
    {
        for(int row = 0; row < currentScan.length; row++)
        {
            for(int col = 0; col < currentScan[0].length; col++)
            {
                // each cell has the specified probablily of being a false positive
                if(Math.random() < noiseFraction)
                {
                    currentScan[row][col] = true;
                }
            }
        }
    }
    
    /**
     * Finds the dx and dy between all hits from the last two scans, then increments that combination by 1
     * 
     */
    public void checkDyDx()
    {
        ///Many nested loops to check everything all at once
        //First find where the previous scan is true, IE a hit was made on the radar
        for(int row = 0; row < prevScan.length; row++)
        {
            for(int col = 0; col < prevScan[0].length; col++)
            {
                if (prevScan[row][col])
                {
                    //Now check if the point has any neighbors within 5x and 5y in any direction
                    for (int i = row; i <= (row+5); i++)
                    {
                        for (int j = col; j <= (col+5); j++)
                        {
                            //if it does, increment that dydx value by one
                            //The first bracket is just the way i figured out how to increment
                            //the correct value by one, based on the way i constructed dydx
                            if ((i < currentScan.length) && j < (currentScan[0].length) && currentScan[i][j])
                            {
                                dydx[((i-row)+((j-col)*6))][2]++;
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Returns most common dx dy combination
     * 
     * @return the integer array of the most common dx dy combination
     */
    public int[] getDyDx()
    {
        int highest = 0;
        for (int i = 0; i< dydx.length; i++)
        {
            if (dydx[i][2] > highest)
            {
                highest = i;
            }
        }

        return dydx[highest];
    }
}
