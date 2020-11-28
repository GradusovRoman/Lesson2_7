package geekbrains.lesson2_7gb.Server;

import geekbrains.lesson2_7gb.entity.User;

public interface DbManager {
    User getUserByEmail(String email);

    void updateUsername(String email, String newNickname);
}