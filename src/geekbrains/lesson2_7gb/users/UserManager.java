package geekbrains.lesson2_7gb.users;

import geekbrains.lesson2_7gb.entity.User;


public interface UserManager {
    void changeName(User user, String newName);
}