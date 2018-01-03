package Nawfall_src.model;

//OBSERVERA DETTA ÄR ENDAST ETT EXEMPEL FÖR SIMPELT JAVA SOCKET PROGRAM
//Länk till yt video: https://www.youtube.com/watch?v=vCDrGJWqR8w
//Client programmet!!!

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {

    public static void main(String args[]) throws IOException {
        simpleMessage();

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

}
