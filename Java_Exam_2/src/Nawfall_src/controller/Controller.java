package Nawfall_src.controller;

import Nawfall_src.model.SocketClient;
import Server.Model.CollectionOfUsers;
import Nawfall_src.model.UserManagerDontUse;
import Server.Model.UserManager;

import java.io.IOException;
import java.util.ArrayList;


public class Controller {
    private CollectionOfUsers users;

    public Controller() throws Exception {

        
    }

    public boolean tryLogin(String email, String password){
        try {
            ArrayList[] emailsAndPassword = SocketClient.loginSocket();
            ArrayList<String> emails = emailsAndPassword[0];
            ArrayList<String> passwords = emailsAndPassword[1];
            for(int i=0; i< emails.size() ; i++){
                if(emails.get(i).equals(email) && passwords.get(i).equals(password)){
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public String getNameByEmail(String email){

        for(int i=0;i<users.getUsers().size();i++){
            if(users.getUsers().get(i).getEmail().equals(email)){
                return users.getUsers().get(i).getName();
            }
        }
        return "not found";
    }
}
