/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sequential;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author 16817
 */
public class Client {

    public static void main(String[] args) throws Exception {
        for(int i=0;i<5;i++){
            runClient();
        }
    }

    public static void runClient() throws Exception{
        int a;
        int b;
        int c;
        int d;

        System.out.println();
        Socket socket = new Socket("127.0.0.1", 12345);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        
        a = Integer.parseInt(in.readObject() + "");
        b = Integer.parseInt(in.readObject() + "");
        c = Integer.parseInt(in.readObject() + "");
        d = Integer.parseInt(in.readObject() + "");

        Util util = new Util();
        out.writeObject(util.calculateX(a, b, c, d));
    }
}
