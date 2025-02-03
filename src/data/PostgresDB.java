package data;

import data.interfaces.IDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IDB {
    private static PostgresDB instance;

    private PostgresDB() {} // Приватный конструктор

    public static PostgresDB getInstance() {
        if (instance == null) {
            instance = new PostgresDB();
        }
        return instance;
    }

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/endterm";
        String user = "postgres";
        String password = "1012";
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }
}
