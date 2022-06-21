/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author annel
 */
public class ServerRMI {
    public static void main(String[] args) {
        try {
             // 1099 RMI default port
            final int PORT = 2011;
            
            Registry registry = LocateRegistry.createRegistry(PORT);
          // rock paper scissors ppt
            registry.rebind("ppt", new ServerImplements());
            
            System.out.println("Server started!");
            
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
