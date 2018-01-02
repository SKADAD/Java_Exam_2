//OBSERVERA DETTA ÄR ENDAST ETT EXEMPEL FÖR SIMPELT JAVA SOCKET PROGRAM
//Länk till yt video: https://www.youtube.com/watch?v=vCDrGJWqR8w


/*package Server.Model;

import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServerSocketHandler {

    public static void main(String args[]) throws UnknownHostException {
        int number, temp;
        Scanner sc = new Scanner(System.in);
        Socket s = new Socket("127.0.0.1", 9999);
        Scanner sc1 = new Scanner(s.getInputStream());
        System.out.println(("Enter any number"));
        number = sc.nextInt();
        PrintStream p = new PrintStream(s.getOutputStream());
        p.println(number);
        temp = sc1.nextInt();
        System.out.println(temp);



    }

}
*/