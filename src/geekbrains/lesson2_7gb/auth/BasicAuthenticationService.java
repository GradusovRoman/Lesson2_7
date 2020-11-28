package geekbrains.lesson2_7gb.auth;
import geekbrains.lesson2_7gb.entity.User;
import geekbrains.lesson2_7gb.Server.DbManager;


import java.util.Optional;

public class BasicAuthenticationService implements AuthenticationService {
    private DbManager databaseService;

    public BasicAuthenticationService(DbManager databaseService) {
        this.databaseService = databaseService;
    }

    @Override
    public Optional<User> doAuth(String email, String password) {
        User user = databaseService.getUserByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(password)) return Optional.of(user);
        }
        return Optional.empty();
    }
}