/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sequential;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author 16817
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        ServerSocket server = new ServerSocket(12345);
        
        int sum = 0;

        for(int i=0;i<5;i++){
            sum += processClient(server, i);
        }
        long ended = System.nanoTime();

        System.out.println("RESULT: "+sum+" TIME(ms)"+(ended-startTime));
        
    }

    public static int processClient(ServerSocket server,int conn)throws Exception {
        System.out.println("Server is waiting for connection "+conn+" ...");
        Socket client = server.accept();
        System.out.println("Connection is accepted");
        Util util = new Util();
        int random[] = util.getRandom();
        System.out.println("Server sends information "+random[0]+" "+random[1]+" "+random[2]+" "+random[3]+" to client "+conn);
        System.out.println("Client processing data ... ");
        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(client.getInputStream());

        
        out.writeObject(random[0]);
        out.writeObject(random[1]);
        out.writeObject(random[2]);
        out.writeObject(random[3]);
        

        int result = Integer.parseInt(in.readObject() + "");
        System.out.println("Client "+conn+" returns "+result);
        System.out.println("\n");
        
        return result;
    }
}
