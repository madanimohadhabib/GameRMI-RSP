/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import RMI.RemoteInterface;
import java.io.Serializable;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 *
 * @author annel
 */
public class ServerImplements extends UnicastRemoteObject implements RemoteInterface, Serializable  {
    
    // remote object version number - serializable object
    // i.e. it can be sent over the network
    // private static final long serialVersionUID = 1L;
    
    public ServerImplements() throws RemoteException {
        super();
    }
    
    @Override
    public String chooseOfServer() throws RemoteException {
        String [] choices = {"rock", "scissors", "paper"};
        
        // generate random index from 0 to 2, to get some choice from the server
        Random random = new Random();
        int index  = random.nextInt(3);
        
        return choices[index];
    }
    
    @Override
    public String winner(String usuario, String servidor) {
        // pedra quebra tesoura, tesoura corta papel e papel amassa a pedra
        if (usuario.equals("rock") && servidor.equals("scissors") ||
            usuario.equals("scissors") && servidor.equals("paper") ||
            usuario.equals("paper") && servidor.equals("rock"))
            return "User";
        else if (servidor.equals("rock") && usuario.equals("scissors") ||
                servidor.equals("scissors") && usuario.equals("paper") ||
                servidor.equals("paper") && usuario.equals("rock"))
            return "server";
        
        // draw é empate
        return "draw";
    }
    
}