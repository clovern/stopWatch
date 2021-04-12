package stopwatch;

import java.io.*;
import java.util.Scanner;

/*****************************************************************
 ********   StopWatch Class
 *Creates stopwatch with minutes, seconds, and milliseconds place
 *
 * @author Nicole Dudas
 * @version Winter 2021
 */

import java.text.*;
import java.lang.IllegalArgumentException;

public class StopWatch {
    private int minutes;
    private int seconds;
    private  int milliseconds;

    //determines if mutation of All StopWatch instances is suspended or not
    private static boolean suspend = false;

    /***************************************************************************************
     * Basic constructor for StopWatch. Sets all time values to default value of 0.
     ***************************************************************************************/
    public StopWatch() {
        minutes = 0;
        seconds = 0;
        milliseconds = 0;
    }

    /***************************************************************************************
     * Constructor 2 for StopWatch.
     * 
     * @param String startTime - starting time of stopwatch in form
     *               "minutes:seconds:milliseconds"
     ***************************************************************************************/
    public StopWatch(String startTime) {
        if (startTime == null) {
            throw new IllegalArgumentException();
        }

        //splits the time String on ":" to find the minutes, seconds and milliseconds value
        String milliTemp = "0";
        String secondsTemp = "0";
        String minutesTemp = "0";
        String[] splitTime = startTime.split(":");

        //determines if each value applies to ms, sec, or mins based on number of values in startTime
        if (splitTime.length == 1) {
            milliTemp = splitTime[0];
        } else if (splitTime.length == 2) {
            secondsTemp = splitTime[0];
            milliTemp = splitTime[1];
        } else {
            minutesTemp = splitTime[0];
            secondsTemp = splitTime[1];
            milliTemp = splitTime[2];
        }

        //turns String values into integer values, and then sets StopWatch time values to the provided values if valid
        setMilliseconds(Integer.parseInt(milliTemp));
        setSeconds(Integer.parseInt(secondsTemp));
        setMinutes(Integer.parseInt(minutesTemp));
    }

    /***************************************************************************************
     * Constructor 3 for StopWatch.
     * 
     * @param int minutes - starting minute value
     * @param int seconds - starting seconds value
     * @param int milliseconds - starting milliseconds value
     ***************************************************************************************/
    public StopWatch(int minutes, int seconds, int milliseconds) {

        //sets this StopWatch's start time to provided values as long as they are valid.
        setMinutes(minutes);
        setSeconds(seconds);
        setMilliseconds(milliseconds);
    }

    /***************************************************************************************
     * Constructor 4 for StopWatch.
     * 
     * @param StopWatch stopWatch - existing StopWatch. The time of this existing
     *                  StopWatch object will be assigned as the starting time for
     *                  your newly constructed StopWatch object.
     ***************************************************************************************/
    public StopWatch(StopWatch stopWatch) {
        if (stopWatch == null)
            throw new IllegalArgumentException();
        
        this.minutes = stopWatch.minutes;
        this.seconds = stopWatch.seconds;
        this.milliseconds = stopWatch.milliseconds;
    }

    /***************************************************************************************
     * Constructor 5 for StopWatch. Minutes value is set to default of 0, and
     * seconds and milliseconds are provided as parameters.
     * 
     * @param int seconds - starting seconds value
     * @param int milliseconds - starting milliseconds value
     ***************************************************************************************/
    public StopWatch(int seconds, int milliseconds) {

        setSeconds(seconds);
        setMilliseconds(milliseconds);
        this.minutes = 0;
    }

    /***************************************************************************************
     * Constructor 6 for StopWatch. Minutes and seconds are assigned to default
     * value of 0. Milliseconds is provided as a parameter.
     * 
     * @param int milliseconds - starting milliseconds value
     ***************************************************************************************/
    public StopWatch(int milliseconds) {

        setMilliseconds(milliseconds);
        this.seconds = 0;
        this.minutes = 0;
    }

    /***************************************************************************************
     * determines equality of one StopWatch object with another based on current
     * time value.
     * 
     * @param StopWatch stopWatch1 - first stopWatch
     * @param StopWatch stopWatch2 - second stopWatch, which will be compared to
     *                  first stopWatch for equality.
     ***************************************************************************************/
    public static boolean equals(StopWatch stopWatch1, StopWatch stopWatch2) {

        //returns true if the seconds, milliseconds, and minutes values of both stopwatches are identical. Otherwise, returns false. 
        return (stopWatch1.getMinutes() == stopWatch2.getMinutes() && stopWatch1.getSeconds() == stopWatch2.getSeconds()
                && stopWatch1.getMilliseconds() == stopWatch2.getMilliseconds());
    }

    /***************************************************************************************
     * determines equality of current StopWatch with another object based on the
     * current time value.
     * 
     * @param Object object - the object to compare to this StopWatch for equality.
     ***************************************************************************************/
    public boolean equals(Object object) {

        /*determines if the object is of StopWatch type. If it is, turns it into a stopWatch object
        and compares time values for equality*/
        if (object instanceof StopWatch) {
            StopWatch watch = (StopWatch) object;
            return StopWatch.equals(watch, this);
        }
        return false;
    }

    /***************************************************************************************
     * Determines if this StopWatch instance is greater than, equal to, or less than
     * the inputted StopWatch instance. If this StopWatch instance is greater than,
     * returns 1. If equal to, returns 0. If less than, returns -1.
     * 
     * @param StopWatch other - StopWatch to compare this StopWatch instance to.
     * @return int - comparative value: 1 this StopWatch is greater. 0 if this
     *         StopWatch is equal to. -1 if this StopWatch is less than.
     ***************************************************************************************/
    public int compareTo(StopWatch other) {
        if (other == null)
            throw new IllegalArgumentException();

        /*Sequentially determines first if minutes, then seconds, then milliseconds is greater in this StopWatch than 
        other StopWatch. If so, returns the appropriate value. Otherwise, returns that they are equal.*/
        if (this.getMinutes() > other.getMinutes()) {
            return 1;
        } else if (this.getMinutes() < other.getMinutes()) {
            return -1;
        } else {
            if (this.getSeconds() > other.getSeconds()) {
                return 1;
            } else if (this.getSeconds() < other.getSeconds()) {
                return -1;
            } else {
                if (this.getMilliseconds() > other.getMilliseconds()) {
                    return 1;
                } else if (this.getMilliseconds() < other.getMilliseconds()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    /***************************************************************************************
     * Helper method to convert stopWatch minutes, seconds, and milliseconds time
     * into a value in milliseconds
     * 
     * @param StopWatch stopWatch - stopWatch to convert
     * @return int - milliseconds value of stopWatch's time.
     ***************************************************************************************/
    private static int convertToMilli(StopWatch stopWatch) {
        if (stopWatch == null)
            throw new IllegalArgumentException();

        /*converts minutes and seconds of the stopWatch into millisecond equivalencies, then adds these to the 
        StopWatch's current milliseconds*/
        int swMilliseconds = stopWatch.getMilliseconds();
        swMilliseconds += stopWatch.getSeconds() * 1000;
        swMilliseconds += stopWatch.getMinutes() * 60 * 1000;

        return swMilliseconds;
    }

    /***************************************************************************************
     * Helper method to convert time in milliseconds to a time in minutes, seconds,
     * and milliseconds.
     * 
     * @param String tempMilliseconds - a millisecond value to be converted
     ***************************************************************************************/
    private void convertToStopWatch(int tempMilliseconds) {

        minutes = tempMilliseconds / 60000;
        tempMilliseconds %= 60000;

        seconds = tempMilliseconds / 1000;
        tempMilliseconds %= 1000;

        milliseconds = tempMilliseconds;
    }

    /***************************************************************************************
     * Adds a millisecond value to the current stopwatch's time
     * 
     * @param int milliseconds - milliseconds to add
     ***************************************************************************************/
    public void add(int milliseconds) {
        if (!suspend) {
            for (int i = 0; i < milliseconds; ++i) {
                this.inc();
            }
        }
    }

    /***************************************************************************************
     * Subtracts a millisecond value from the current stopwatch's time.
     * 
     * @param int milliseconds - millisecond value to be subtracted
     ***************************************************************************************/
    public void sub(int milliseconds) {
        if (!suspend) {
            for (int i = 0; i < milliseconds; ++i) {
                this.dec();
            }
        }
    }

    /***************************************************************************************
     * Adds the time of an inputted stopwatch parameter to this stopwatch
     * 
     * @param StopWatch stopWatch - stopWatch to add
     ***************************************************************************************/
    public void add(StopWatch stopWatch) {
        if (!suspend) {
            
            //converts stopWatch parameter's value to milliseconds, then adds that amount. 
            this.add(StopWatch.convertToMilli(stopWatch));
        }
    }

    /***************************************************************************************
     * Subtracts the time of an inputted stopwatch parameter to this stopwatch
     * 
     * @param StopWatch stopWatch - stopWatch to subtract.
     ***************************************************************************************/
    public void sub(StopWatch stopWatch) {
        if (!suspend) {

            //convert's stopWatch parameter's value to milliseconds, then subtracts that amount
            this.sub(StopWatch.convertToMilli(stopWatch));
        }
    }

    /***************************************************************************************
     * Increments this StopWatch's millisecond value by 1 millisecond.
     ***************************************************************************************/
    public void inc() {
        if (!suspend) {

            /*if adding on millisecond will create a full new second or new minute, adjusts accordingly.
            Otherwise, adds one second*/
            if (milliseconds == 999) {
                milliseconds = 0;
                if (seconds == 59) {
                    seconds = 0;
                    minutes++;
                    return;
                }
                seconds++;
                return;
            }
            milliseconds++;
        }
    }

    /***************************************************************************************
     * Decrements this StopWatch's milisecond value by 1 millisecond
     ***************************************************************************************/
    public void dec() {
        if (!suspend) {

            /*Determines that there is time available to decrement. If milliseconds value is at 0, 
            adjusts seconds and minutes value accordingly. Otherwise, decrements by 1 ms.*/
            if (milliseconds == 0 && seconds == 0 && minutes == 0) {
                return;
            }
            if (milliseconds == 0) {
                if (seconds == 0) {
                    minutes--;
                    seconds = 59;
                    milliseconds = 999;
                    return;
                }
                seconds--;
                milliseconds = 999;
                return;
            }
            milliseconds--;
        }
    }

    /***************************************************************************************
     * Creates a string representation of this StopWatch object which can be
     * outputted.
     * 
     * @return String stopWatchString - string containing this StopWatch's time in
     *         format "minutes:seconds:milliseconds"
     ***************************************************************************************/
    public String toString() {
        NumberFormat fmtMinSec = new DecimalFormat("00");
        NumberFormat fmtMilli = new DecimalFormat("000");
        String stopWatchString = minutes + ":" + fmtMinSec.format(seconds) + ":" + fmtMilli.format(milliseconds);
        return stopWatchString;
    }

    /***************************************************************************************
     * Saves the current stopWatch's time to the provided file.
     * 
     * @param String filename - file to save this StopWatch to.
     ***************************************************************************************/
    public void save(String filename) {
        if (filename == null)
            throw new IllegalArgumentException();

        PrintWriter out = null;

        /*writes the value of the StopWatch to the provided filename if able. Handles exception
        if provided file is not able to be used*/
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));

            out.println(minutes + " " + seconds + " " + milliseconds);

            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***************************************************************************************
     * Loads the time from a file onto this StopWatch.
     * 
     * @param String filename - name of file to retrieve stopwatch time from.
     ***************************************************************************************/
    public void load(String filename) {
        if (filename == null)
            throw new IllegalArgumentException();

        Scanner scanner = null;

        /*retrieves value for minutes, seconds, and milliseconds from a file, and assigns those values to this
        StopWatch.*/
        try {
            Scanner fileReader = new Scanner(new File(filename));

            minutes = fileReader.nextInt();
            seconds = fileReader.nextInt();
            milliseconds = fileReader.nextInt();

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Please load from a .txt file with only one StopWatch time");
        }
    }

    /***************************************************************************************
     * suspends or unsuspends ALL StopWatch instances to block or allow mutation of
     * time value.
     * 
     * @param boolean suspend - determines if StopWatch mutation is suspended. True
     *                for suspended, false for not suspended.
     ***************************************************************************************/
    public static void setSuspend(boolean suspend) {
        StopWatch.suspend = suspend;
    }

    /***************************************************************************************
     * determines if stopWatch time mutation is currently suspended
     * 
     * @return boolean - true if mutation is suspended, false if it is not
     *         suspended.
     ***************************************************************************************/
    public static boolean isSuspended() {
        return (StopWatch.suspend == true);
    }

    /***************************************************************************************
     * returns the minute value of this StopWatch
     * 
     * @return minutes - minute value
     ***************************************************************************************/
    public int getMinutes() {
        return minutes;
    }

    /***************************************************************************************
     * sets minute value of this StopWatch
     * 
     * @param int minutes - minute value to set
     ***************************************************************************************/
    public void setMinutes(int minutes) {
        if (minutes >= 0) {
            this.minutes = minutes;
        } else {
            throw new IllegalArgumentException("minutes value must be >= 0");
        }
    }

    /***************************************************************************************
     * returns the seconds value of this StopWatch
     * 
     * @return int seconds - seconds value
     ***************************************************************************************/
    public int getSeconds() {
        return seconds;
    }

    /***************************************************************************************
     * sets new seconds value for this StopWatch
     * 
     * @param int seconds - new seconds value to set
     ***************************************************************************************/
    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds < 60) {
            this.seconds = seconds;
        } else {
            throw new IllegalArgumentException("seconds value must be 0-59");
        }
    }

    /***************************************************************************************
     * returns millisecond value for this StopWatch
     * 
     * @return int milliseconds - milliseconds value
     ***************************************************************************************/
    public int getMilliseconds() {
        return milliseconds;
    }

    /***************************************************************************************
     * sets new milliseconds value for this StopWatch
     * 
     * @param int milliseconds - new milliseconds value to set
     ***************************************************************************************/
    public void setMilliseconds(int milliseconds) {
        if (milliseconds >= 0 && milliseconds < 1000) {
            this.milliseconds = milliseconds;
        } else {
            throw new IllegalArgumentException("seconds value must be 0-59");
        }
    }
}