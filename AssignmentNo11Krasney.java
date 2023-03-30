// This program was written by Alexandra Krasney on March 6th, 2023

/**
 * Pseudo-Code 
 * 
 * 1) Establish Time class and its private properties 
 * 2) Establish the four necessary constructors for the Time class 
 * 3) Determine first how to detect if the time needs to be 
 * denominated in either AM or PM by determining the actual timestamp first,
 * and then using the modulo operation to determine the appropriate 
 * demonination for the given timestamp in question
 * 4) Write the five necessary methods, saving the toString() and write()
 * methods for last, due to the necessity of determining the denomination first 
 * 5) Demonstrate that the created classes work 
 */


import java.util.Arrays;
import java.util.Scanner;


    

 

public class AssignmentNo11Krasney {
    public static void main(String[] args) {
        // To demonstrate the properties of the Time 
        // later(int newSeconds, int newMinutes, int newHours) by 
        // setting a pre-existing time object to midnight, and then 
        // setting its time to be four hours, twenty-seven minutes, 
        // and fifteen seconds later
        
        Time Example = new Time();
        
        System.out.println(Example.toString());
        
        Time modExample = Example.later(15, 27, 4);
        
        System.out.println(modExample.toString());
    
    }

}

