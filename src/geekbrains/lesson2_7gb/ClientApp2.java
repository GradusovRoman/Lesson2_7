package geekbrains.lesson2_7gb;

import geekbrains.lesson2_7gb.log.ClientLog;
import geekbrains.lesson2_7gb.log.LoggerService;

    public class ClientApp2 {
        public static void main(String[] args) {
            new ClientLog("localhost", 8888, new LoggerService("C:\\java\\temporary\\client2\\log.txt")).run();
        }
    }
