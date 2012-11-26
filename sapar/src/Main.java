/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author baha
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("TIME:");
        while (true) {
            System.out.println("MILLISECONDS:[" + System.currentTimeMillis() + "]");
            System.out.println("NANOSECONDS:[" + System.nanoTime() + "]");
        }
    }
}
