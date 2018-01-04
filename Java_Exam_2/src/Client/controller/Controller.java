package Client.controller;

import Client.view.Main;
import Server.Model.CollectionOfUsers;

import java.util.ArrayList;


public class Controller {
    private CollectionOfUsers users;

    public Controller() throws Exception {

        
    }

    public boolean tryLogin(String email, String password){
        ArrayList[] emailsAndPassword = Main.emailsAndPasswords;
        ArrayList<String> emails = emailsAndPassword[1];
        ArrayList<String> passwords = emailsAndPassword[2];
        for(int i=0; i< emails.size() ; i++){
            if(emails.get(i).equals(email) && passwords.get(i).equals(password)){
                return true;
            }
        }
        return false;
    }

    public Integer getidfrommail(String email){
        ArrayList[] idEmailsAndPassword = Main.emailsAndPasswords;
        ArrayList<Integer> ids = idEmailsAndPassword[0];
        ArrayList<String> emails = idEmailsAndPassword[1];
        int indexOfEmail = 0;
        for(int i=0;i<ids.size();i++){
            if(email.equals(emails.get(i))){
                indexOfEmail = i;

                int idToReturn = ids.get(indexOfEmail);
                return idToReturn;
            }
        }
        return null;
    }
}
