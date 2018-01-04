package Nawfall_src.controller;

import Nawfall_src.view.Main;
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
        for(int i=0;i<ids.size();i++){
            System.out.println(ids.get(i));
            System.out.println(emails.get(i));
            if(ids.get(i).equals(emails.get(i))){
                return ids.get(i);
            }
        }
        return null;
    }
}
