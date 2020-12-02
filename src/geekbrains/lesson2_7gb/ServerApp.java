package geekbrains.lesson2_7gb;
import geekbrains.lesson2_7gb.Server.ChatServer;
import geekbrains.lesson2_7gb.db.PostgresService;

    public class ServerApp {
        public static void main(String[] args) {

            new ChatServer(new PostgresService());
        }
    }
