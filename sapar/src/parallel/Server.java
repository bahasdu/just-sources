/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parallel;

import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 *
 * @author 16817
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ProcessorSingleton.getPs();
        ServerSocket server = new ServerSocket(12345);
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i=1;i<5;i++){
            service.execute(new ServerSideHandler(server, i));
        }
//        Thread.sleep(1000000);
    }

}
