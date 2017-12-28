package Nawfall_src.controller;

import Nawfall_src.model.CollectionOfUsers;
import Nawfall_src.model.UserManager;


public class Controller {
    private CollectionOfUsers users;

    public Controller() {
        this.users = UserManager.getAllUsers();
        
    }

    public boolean tryLogin(String email, String password){
        for(int i=0; i<users.getUsers().size() ; i++){
            if(users.getUsers().get(i).getEmail().equals(email) && users.getUsers().get(i).getPassword().equals(password)){
                return true;
            }
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
