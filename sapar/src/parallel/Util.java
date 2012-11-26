/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parallel;

import parallel.*;
import sequential.*;
import java.util.Random;

/**
 *
 * @author 16817
 */
public class Util {
    public int calculateX(int a,int b,int c,int d){
        int z =c*d;
        int y=a+b;
        int x=y+z;
        return x;
    }
    public int[] getRandom(){
        int a[] = new int [4];
        Random random = new Random();
        for(int i=0;i<4;i++)
            a[i] = random.nextInt(100) % 5;
                
        return a;
    }
    public int getRandomInt(int range){
        Random random = new Random();
        return random.nextInt(100) % range+1;
    }
}
