package com.orion.domotica;

import java.util.ArrayList;

import com.orion.domotica.action.ActionManagement;
import com.orion.domotica.device.DeviceManagement;
import com.orion.domotica.scenario.ScenarioManagement;
import com.orion.domotica.user.User;
import com.orion.domotica.user.UserManagement;

public class Domotica {
    UserManagement umanager;
    DeviceManagement dmanager;
    ScenarioManagement smanager;
    ActionManagement amanager;

    public Domotica() {
        umanager = new UserManagement();
        dmanager = new DeviceManagement();
        smanager = new ScenarioManagement();
        amanager = new ActionManagement();
    }

    void setUser(String username) {
        umanager.setUser(username);
    }

    public void saveUser(User user) {
        // save the user to a file
        String path = Domotica.class.getResource("users/users.txt").getPath();
        Main.saveToFile(path, user.toString());
        
    }

    public void loadUsers() {
        // load the users from a file
        String path = Domotica.class.getResource("users/users.txt").getPath();
        Main.loadFromFile(path);
    }

    public void addUser(String user) {
        User loaded;
        String[] data = user.split(";");
        if (data[4].equals("-1")) {
            loaded = umanager.createAdminUser(data[0], data[1], data[2], data[3]);
        } else {
            data[4] = data[4].replace("\n", "");
            loaded = umanager.createUser(data[1], data[2], Integer.parseInt(data[4]));
        }
        System.out.println(loaded.getUserDetails());
    }

    public void login(String user, String pass) {
        User foundUser = umanager.getUserByUsername(user);
        if (foundUser != null) {
            if (foundUser.getPassword().equals(pass)) {
                System.out.println("Login successful!");
                umanager.setUser(user);
                Main.setScene("user_logged.fxml");
            } else {
                System.out.println("Wrong password!");
            }
        } else {
            System.out.println("User not found!");
        }
    }

    public boolean isAdmin() {
        return umanager.getUser().isAdmin();
    }

    public ArrayList<User> getChildUsers() {
        ArrayList<User> childUsers = new ArrayList<>();

        umanager.getAllUsers().forEach(u -> {
            if (u.ownerId == umanager.getUser().userId) {
                childUsers.add(u);
            }
        });

        return childUsers;
    }

    public User getUser() {
        return umanager.getUser();
    }

    public void deleteUser(User u) {
        umanager.removeUser(u);
    }
}
