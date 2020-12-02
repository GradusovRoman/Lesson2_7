package geekbrains.lesson2_7gb.log;

public interface Logger {
    void addMessage(String message);

    String getLastMessages(int limit);
}