package com.orion.domotica.user;

public class User {
    private static int LastUserId = 0;
    public final int userId;
    public final String email;
    public String username;
    public String password;
    public String addr;
    public final int ownerId;

    // Costruttore per utente normale
    public User(String username, String password, int ownerId) {
        this.email = "";
        this.addr = "";
        this.userId = ++LastUserId;
        this.username = username;
        this.password = password;
        this.ownerId = ownerId;
    }

    // Costruttore per utente amministratore
    public User(String email, String username, String password, String addr) {
        this.userId = ++LastUserId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.addr = addr;
        this.ownerId = -1;
    }

    // Metodo per ottenere l'ID dell'utente
    public int getUserId() {
        return userId;
    }

    // Metodo per ottenere il nome utente dell'utente
    public String getUsername() {
        return username;
    }

    // Metodo per verificare se l'utente è amministratore
    public boolean isAdmin() {
        return ownerId == -1;
    }

    // Metodo per verificare la correttezza delle credenziali
    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public String getAddr() {
        return addr;
    }

    // Metodo per ottenere i dettagli dell'utente
    public String getUserDetails() {
        return "User ID: " + userId + "\nUsername: " + username + "\nEmail: " + email + "\nAddress: " + addr
                + "\nStatus: " + (ownerId == -1 ? "Admin" : "Normal");
    }

    @Override
    public String toString() {
        return email + ";" + username + ";" + password + ";" + addr + ";" + ownerId + "\n";
    }

    public String getPassword() {
        return this.password;
    }
}
