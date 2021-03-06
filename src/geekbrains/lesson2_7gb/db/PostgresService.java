package geekbrains.lesson2_7gb.db;

import geekbrains.lesson2_7gb.entity.User;
import geekbrains.lesson2_7gb.Server.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresService implements DbManager {

    private static final String url = "jdbc:postgresql://localhost:5432/ChatData";
    private static final String user = "simply";
    private static final String password = "1";

    public PostgresService() {

    }

    @Override
    public User getUserByEmail(String email) {
        Connection connection = DbService.getConnection(url, user, password);
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "Select * From public.\"Users\" where \"Email\" = ? Limit 1");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getString("Name"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password")
                );
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("SWW during get user from database", e);
        } finally {
            DbService.close(connection);
        }
    }

    @Override
    public void updateUsername(String email, String newName) {
        Connection connection = DbService.getConnection(url, user, password);
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "Update public.\"Users\" set \"Name\" = ? where \"Email\" = ?");
            statement.setString(1, newName);
            statement.setString(2, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            DbService.rollback(connection);
            throw new RuntimeException("SWW during update username", e);
        } finally {
            DbService.close(connection);
        }
    }
}