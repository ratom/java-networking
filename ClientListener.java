/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atom.hs.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author rabin dulal
 */
public class ClientListener extends Thread{
    
    private Socket client;

    public ClientListener(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try{
                PrintStream output= new PrintStream(client.getOutputStream());
                System.out.print("hello client!  welcome to my server");
                BufferedReader input=new BufferedReader(new InputStreamReader(client.getInputStream()));
                String line=input.readLine();
                System.out.println(line);
                output.print("your message is"+line);
                if( line.equalsIgnoreCase("notepad")){
                Process p=new ProcessBuilder("notepad").start();
                }
                output.flush();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
     
    
}
