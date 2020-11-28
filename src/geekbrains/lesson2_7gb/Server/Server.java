package geekbrains.lesson2_7gb.Server;

import geekbrains.lesson2_7gb.auth.AuthenticationService;
import geekbrains.lesson2_7gb.users.UserService;

public interface Server {
    void broadcastMessage(String message, String from);
    void sendPrivateMessage(String message, String from);
    boolean isLoggedIn(String nickname);
    void subscribe(ClientHandler client);
    void unsubscribe(ClientHandler client);
   AuthenticationService getAuthenticationService();
    UserService getUserService();
}