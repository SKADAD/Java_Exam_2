package Nawfall_src.model;

import Server.Model.CollectionOfUsers;

import java.io.*;

public abstract class UserManagerDontUse {
    public static CollectionOfUsers getAllUsers() throws Exception {
        CollectionOfUsers users = null;
        try {
            FileInputStream fileIn = new FileInputStream("users.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            users = (CollectionOfUsers) in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException i) {

        } catch (ClassNotFoundException c) {

        }
        return users;
    }

    public static void saveUsers(CollectionOfUsers users) throws Exception {
        try {

            FileOutputStream fileOut =
                    new FileOutputStream("users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.close();
            fileOut.close();
        } catch (IOException i) {

        }
    }

}
