package com.beginnerlevel.threading;

public class FirstThreadExtendsThread extends Thread {
	
	public void run() 
    { 
        try
        { 
            // Displaying the thread that is running 
            System.out.println ("FirstThreadExtendsThread " + 
                  Thread.currentThread().getId() + 
                  " is running"); 
  
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
}
