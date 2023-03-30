// This was written on March 6th, 2023 by Alexandra Krasney

import java.util.Scanner; 
import java.util.Arrays;

class Time {
    private int Seconds = 0;
    private int Minutes = 0;
    private int Hours = 0; 
    
    
    // Function that determines whether or not a given value for a time objects's seconds or 
    // minutes exceeds the value of sixty, and fixes the values accordingly. 
    // This checking function is written first in the code as it is perhaps the most important 
    // function for a program whose purpose is to generate and printout timestamps 
    public int[] valueCheck(int inputtedSeconds, int inputtedMinutes, int inputtedHours) {
        // To create the array that will return all the fixed version of the variable that were the 
        // inputs of this function
        int[] fixedValueArray = new int[3];
        
        
        // Seconds are determined first, as they are the smallest unit of time in this program,
        // and subseuquently affect all the other units of time in this program if they go 'overboard'
        // 60. All the variables whose names start with the word 'condensed' exist as to account for 
        // the extra minutes or hours that would be created as a result of converting seconds and/or 
        // minutes into legitimate values of seconds or minutes
        
        int condensedMinutes = inputtedSeconds / 60; 
        int freeSeconds = inputtedSeconds % 60;
        fixedValueArray[0] = freeSeconds; 
        
        
        // To determine the amount of minutes that are in the inputted timestamp.
        int inputtedMinutesFixed = inputtedMinutes + condensedMinutes; 
        int condensedHours = inputtedMinutesFixed / 60;
        int freeMinutes = inputtedMinutesFixed % 60;
        fixedValueArray[1] = freeMinutes;
        
        // To determine the amount of hours that are in the inputted timestamp. The fixed value of the hours 
        // entered is modulated by 24 to account for values that exceed that excced the number of hours in a
        // day
        int inputtedHoursFixed1 = inputtedHours + condensedHours; 
        int inputtedHoursFixed2 = inputtedHoursFixed1 % 24;
        fixedValueArray[2] = inputtedHoursFixed2;
        
        return fixedValueArray;
    } 

    
    
    // The functions which retreive the properties of the Time() class. Were written second, given the importance 
    
    public static int getTimeSeconds (Time Example) {
        Time toBeReturned = Example;
        return toBeReturned.Seconds;
        
    }
    
    public static int getTimeMinutes (Time Example) {
        Time toBeReturned = Example;
        return toBeReturned.Minutes; 
    
    }

    public static int getTimeHours (Time Example) {
        Time toBeReturned = Example;
        return toBeReturned.Hours;
    
    }
    
    // To establish the Time() function 
    public Time() {
        Seconds = 0;
        Minutes = 0;
        Hours = 0;
        
        int[] TimeMethodParam = valueCheck(this.Seconds, this.Minutes, this.Hours);
        
        this.Seconds = TimeMethodParam[0];
        this.Minutes = TimeMethodParam[1];
        this.Hours = TimeMethodParam[2];
    }
    
    
    
    // To establish the Time(int newHours) function
    public Time(int newHours) {
        Seconds = 0; 
        Minutes = 0;
        
        Hours = newHours;         
        
        
        // To check the inputted value of this function. The purpose of the hot-potato-ing as seen 
        // down below is to assign the values that were checked to the properties of this method
        int[] TimeMethodParam1 = valueCheck(this.Seconds, this.Minutes, this.Hours); 
        
        this.Seconds = TimeMethodParam1[0];
        this.Minutes = TimeMethodParam1[1];
        this.Hours = TimeMethodParam1[2];
    }
    
    // To establish the Time(int newMinutes, int newHours) function
    public Time(int newMinutes, int newHours) {
        Seconds = 0; 
        
        Minutes = newMinutes;
        Hours = newHours;
    
        int[] TimeMethodParam2 = valueCheck(this.Seconds, this.Minutes, this.Hours);
        
        this.Seconds = TimeMethodParam2[0];
        this.Minutes = TimeMethodParam2[1];
        this.Hours = TimeMethodParam2[2];
        
    }
    
    // To establish the Time(int newSeconds, int newMinutes, int newHours) function
    public Time(int newSeconds, int newMinutes, int newHours) {
        Seconds = newSeconds;
        Minutes = newMinutes;
        Hours = newHours;
        
        int[] TimeMethodParam3 = valueCheck(this.Seconds, this.Minutes, this.Hours);
        
        this.Seconds = TimeMethodParam3[0];
        this.Minutes = TimeMethodParam3[1];
        this.Hours = TimeMethodParam3[2];
    
    
    }
    
    // To establish the toString method 
    public  String toString() {
       // To establish whether or not the inputted Time object should be demoninated with 
       // AM or PM
       String timeDenomination;
    
       // Hours values that are equal or greater to a value of zero and less than a value of 
       // 12 represent hours that would be denominated with AM, as it is such in reality
       if (0 <= this.Hours && this.Hours < 12) {
        timeDenomination = "AM";
        
       } else {
       // Hours values that are equal or greater to 12 and equal or less than a value of 23
       // represent hours that would be label with PM, as it is such in reality
        timeDenomination = "PM";
        
       }
       
       
       String timeString = (this.Hours + ":" + this.Minutes + ":" + this.Seconds + " " + timeDenomination);
       return timeString;
       
    }
    // To establish the write() function
    public void write() {
        System.out.println(this.toString());
    }
    
    // To establish the Time later(int extraHours) function
    public Time later(int extraHours) {
        int startingHours = Time.getTimeHours(this);
        int endingHours = startingHours + extraHours; 
        Time laterTime = new Time(endingHours);
        return laterTime;
    } 
    
    // To establish the Time later(int extraMinutes, int extraHours)
    // function
    public Time later(int extraMinutes, int extraHours) {
        int startingMinutes = Time.getTimeMinutes(this);
        int endingMinutes = startingMinutes + extraMinutes;        
        
        int startingHours = Time.getTimeHours(this);
        int endingHours = startingHours + extraHours;
        
        Time laterTime = new Time(endingMinutes, endingHours);
        return laterTime;
    }
    
    // To establish the Time later(int extraSeconds,int extraMinutes, 
    // int extraHours) function
    public Time later(int extraSeconds, int extraMinutes, int extraHours) {
        int startingSeconds = Time.getTimeSeconds(this);
        int endingSeconds = startingSeconds + extraSeconds;
        
        int startingMinutes = Time.getTimeMinutes(this);
        int endingMinutes = startingMinutes + extraMinutes;        
        
        int startingHours = Time.getTimeHours(this);
        int endingHours = startingHours + extraHours;
        
        int[] laterTimeArray = valueCheck(endingSeconds, endingMinutes, endingHours);
        Time laterTimeFixed = new Time();
        
        laterTimeFixed.Seconds = laterTimeArray[0];
        laterTimeFixed.Minutes = laterTimeArray[1];
        laterTimeFixed.Hours = laterTimeArray[2];
        return laterTimeFixed;
    }
}
