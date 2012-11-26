/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parallel;

import parallel.*;
import parallel.*;

/**
 *
 * @author baha
 */
public class ProcessorSingleton {

    public static ProcessorSingleton ps;
    public volatile static int counter = 0;
    public volatile static int sum = 0;
    public volatile static long startTime;
    private ProcessorSingleton() {
        startTime = System.nanoTime();
    }

    public synchronized void finish(int addition,int conn) {
        System.out.println("Get result ["+addition+"] from connection ["+conn+"]");
        sum += addition;        
        if(++counter==4){
            System.out.println("program is finished ... SUMMATION:"+ sum +" TIME(nanosecond):"+ (System.nanoTime()-startTime));
        }
    }

    public static synchronized ProcessorSingleton getPs() {
        if (ps == null) {
            return new ProcessorSingleton();
        } else {
            return ps;
        }
    }
}
