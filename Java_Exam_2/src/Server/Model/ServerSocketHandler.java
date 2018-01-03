package Server.Model;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketHandler {

    public static void main(String args[]) throws IOException {

        String inputCommand, output;
        ServerSocket s1 = new ServerSocket(9999);
        Socket ss = s1.accept();
        Scanner sc = new Scanner(ss.getInputStream());
        inputCommand = sc.nextLine();

        output = inputCommand;

        PrintStream p = new PrintStream(ss.getOutputStream());
        p.println(output);


    }


}
