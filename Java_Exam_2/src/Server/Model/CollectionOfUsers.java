package Server.Model;

import java.util.ArrayList;

public class CollectionOfUsers{
    public ArrayList<User> users;

    public CollectionOfUsers(ArrayList<User> users) {
        this.users = users;
    }

    public CollectionOfUsers(){
        this.users = new ArrayList<>();
    }

    public boolean addUser(User user){
        for(int i=0 ; i<users.size() ; i++){
            if(user.getEmail().equals(users.get(i).getEmail())){
                return false;
            }
        }
        users.add(user);
        return true;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "CollectionOfUsers{" +
                "users=" + users +
                '}';
    }
}
