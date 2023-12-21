package com.orion.domotica;

import java.util.ArrayList;

import com.orion.domotica.Factory.Factory;
import com.orion.domotica.action.ActionManagement;
import com.orion.domotica.device.Device;
import com.orion.domotica.device.DeviceManagement;
import com.orion.domotica.device.LightBulb;
import com.orion.domotica.device.SmartPlug;
import com.orion.domotica.device.Blinds;
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
        Main.loadUser(path);
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
            System.out.println("CHILD: " + u.username);
            System.out.println(umanager.getUser().userId);

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

    public void logout() {
        umanager.reset();
        dmanager.reset();
    }

    public void addDevice(String id, String name, Factory factory) {
        Device device = factory.createDevice(id, name, getUser().userId);
        dmanager.addDevice(device);
        String path = Domotica.class.getResource("devices/devices.txt").getPath();
        Main.saveToFile(path, device.toString());
    }

    public void loadDevice(String line) {
        // load the device from a file
        // the file contains the device information in the following format:
        // class;id;name;owners;status;value
        // owners is an array of user ids separated by commas
        // either status or value can be omitted, but not both
        // class can be used to determine the type of device and use the correct
        // constructor by reflection

        String[] data = line.split(";");
        for (String s : data) {
            System.out.println(s);
        }

        String id = data[1];
        String name = data[2];
        String ownerId = data[3];
        ownerId = ownerId.replace("[", "");
        ownerId = ownerId.replace("]", "");

        ArrayList<Integer> owners = new ArrayList<>();
        if (ownerId.contains(",")) {
            String[] ownersId = ownerId.split(",");
            for (String owner : ownersId) {
                owners.add(Integer.parseInt(owner));
            }
        } else {
            owners.add(Integer.parseInt(ownerId));
        }

        boolean status = false;
        float value = 0;

        if (!data[4].equals("-"))
            status = Boolean.parseBoolean(data[4]);

        if (!data[5].equals("-"))
            value = Float.parseFloat(data[5]);

        Device device = null;
        try {
            device = (Device) Class.forName(data[0]).getConstructor(String.class, String.class, Integer.class)
                    .newInstance(id, name, owners.get(0));

            if (data[0].equals("com.orion.domotica.device.LightBulb")) {
                ((LightBulb) device).setPower(status);
                ((LightBulb) device).setBrightness(value);
            } else if (data[0].equals("com.orion.domotica.device.SmartPlug")) {
                ((SmartPlug) device).setPower(status);
            } else if (data[0].equals("com.orion.domotica.device.Blinds")) {
                ((Blinds) device).setPosition(value);
            }

            for (int i = 1; i < owners.size(); i++) {
                device.addOwner(owners.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        dmanager.addDevice(device);
    }

    public User createUser(String username, String email, String password, String address) {
        return umanager.createAdminUser(username, email, password, address);
    }
}
