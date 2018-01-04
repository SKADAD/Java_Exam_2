package Nawfall_src.model;

//OBSERVERA DETTA ÄR ENDAST ETT EXEMPEL FÖR SIMPELT JAVA SOCKET PROGRAM
//Länk till yt video: https://www.youtube.com/watch?v=vCDrGJWqR8w
//Client programmet!!!

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class SocketClient {

    public static void main(String args[]) throws IOException {
        //simpleMessage();
        loginSocket();

    }

    public static void simpleMessage() throws IOException {
        String inputCommand, temp;
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("127.0.0.1", 9999);
        Scanner sc1 = new Scanner(s.getInputStream());
        System.out.println(("Enter any number"));
        inputCommand = sc.nextLine();
        PrintStream p = new PrintStream(s.getOutputStream());
        p.println(inputCommand);
        temp = sc1.nextLine();
        System.out.println(temp);

    }


    public static void loginSocket() throws IOException, ClassNotFoundException {
        Socket connct = connect();
        ObjectInputStream ois = new ObjectInputStream(connct.getInputStream());
        ArrayList<String> emails = (ArrayList<String>) ois.readObject();
        ArrayList<String> password = (ArrayList<String>) ois.readObject();
    }

    public static Socket connect() throws IOException {
        Socket s = new Socket("127.0.0.1", 9999);
        return s;
    }
}
