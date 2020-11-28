package geekbrains.lesson2_7gb.users;

import geekbrains.lesson2_7gb.entity.User;
import geekbrains.lesson2_7gb.Server.DbManager;

public class UserService implements UserManager {
    private DbManager databaseService;

    public UserService(DbManager databaseService) {
        this.databaseService = databaseService;
    }

    @Override
    public void changeName(User user, String newName) {
        databaseService.updateUsername(user.getEmail(), newName);
    }
}