/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parallel;

import parallel.*;
import parallel.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author baha
 */
public class ServerSideHandler implements Runnable {

    public ServerSocket server;
    public int conn;

    public ServerSideHandler(ServerSocket server, int conn) {
        this.server = server;
        this.conn = conn;
    }

    @Override
    public void run() {
        try {
            System.out.println("Server is waiting for connection " + conn + " ...");
            Socket client = server.accept();
            System.out.println("Connection is accepted from connection "+conn);
            Util util = new Util();
            int random[] = util.getRandom();
            System.out.println("Server sends information " + random[0] + " " + random[1] + " " + random[2] + " " + random[3] + " to client " + conn);
            System.out.println("Client with connection "+conn+" is processing data ... ");
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());


            out.writeObject(random[0]);
            out.writeObject(random[1]);
            out.writeObject(random[2]);
            out.writeObject(random[3]);


            int result = Integer.parseInt(in.readObject() + "");
            System.out.println("Client " + conn + " returns " + result);
            System.out.println("\n");

            ProcessorSingleton.getPs().finish(result,conn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
