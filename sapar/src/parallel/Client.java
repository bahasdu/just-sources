/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parallel;

import parallel.*;
import sequential.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author 16817
 */
public class Client {

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            service.execute(new ClientSideHandler());
        }

    }

}
