package pattern;

import java.util.ArrayList;
import java.util.List;

public class MediatorApp {
    public static void main(String[] args){
        TextChat chat = new TextChat();

        User1 admin = new Admin(chat);
        User1 u1 = new SimpleUser(chat);
        User1 u2 = new SimpleUser(chat);

        chat.setAdmin(admin);
        chat.addUser(u1);
        chat.addUser(u2);

        u1.sendMessage("Hi, im user!");
        admin.sendMessage("Admin joined to chat");
    }
}

interface User1{
    void sendMessage(String message);
    void getMessage(String message);
}

class Admin implements User1{
    Chat chat;
    public Admin(Chat chat) {this.chat = chat;}
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }
    public void getMessage(String message) {
        System.out.println("Admin get a message" + message);
    }
}

class SimpleUser implements User1{
    Chat chat;
    public SimpleUser(Chat chat) {this.chat = chat;}
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }
    public void getMessage(String message) {
        System.out.println("User get a message" + message);
    }
}

interface Chat{
    void sendMessage(String message, User1 user1);
}

class TextChat implements Chat{
    User1 admin;
    List<User1> users = new ArrayList<>();

    public void setAdmin (User1 admin){
        this.admin = admin;
    }
    public void addUser(User1 u1){
        users.add(u1);
    }
    public void sendMessage(String message, User1 user1) {
        for(User1 u1 : users) {
            u1.getMessage(message);
        }
        admin.getMessage(message);
    }
}