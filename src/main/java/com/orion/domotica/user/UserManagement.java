package com.orion.domotica.user;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {
    private User user;
    private List<User> userList;
    private static int LastUserId = 1;

    public UserManagement() {
        this.user = null;
        this.userList = new ArrayList<>();
    }

    // Metodo per impostare l'utente corrente
    public void setUser(String username) {
        user = getUserByUsername(username);
    }

    // Metodo per ottenere l'utente corrente
    public User getUser() {
        return user;
    }

    // Metodo per creare un nuovo utente normale
    public User createUser(String username, String password, int ownerId) {
        User newUser = new User(username, password, ownerId);
        userList.add(newUser);
        return newUser;
    }

    // Metodo per creare un nuovo utente amministratore
    public User createAdminUser(String username, String email, String password, String addr) {
        User newAdminUser = new User(LastUserId++, username, email, password, addr);
        userList.add(newAdminUser);
        return newAdminUser;
    }

    // Metodo per cercare un utente per ID
    public User getUserById(int userId) {
        for (User user : userList) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null; // Utente non trovato
    }

    // Metodo per cercare un utente per nome utente
    public User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // Utente non trovato
    }

    // Altri metodi utili possono essere aggiunti in base alle esigenze...

    // Metodo per ottenere la lista di tutti gli utenti
    public List<User> getAllUsers() {
        return new ArrayList<>(userList); // Ritorna una copia della lista per evitare modifiche esterne non controllate
    }

    public void removeUser(User u) {
        userList.remove(u);
    }

    public void reset() {
        userList.clear();
        LastUserId = 1;
    }

}
