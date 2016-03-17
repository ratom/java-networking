/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atom.hs;

import com.atom.hs.Handler.ClientListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rabin dulal
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port=1501;
        try {
            System.out.println("server is listenig at "+port);
            ServerSocket server=new ServerSocket(port);
            while(true){
                Socket client=server.accept();
                System.out.println("connection request from" +client.getInetAddress().getCanonicalHostName());
                ClientListener clientListenrer=new ClientListener(client);
                clientListenrer.start();
                
               
                
                
            }
            
            
        } catch (IOException ex) {
           // Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("IO Exception Occured:: "+ex.getMessage());
        }
        
        
        
        
        
    }
    
}
