package repositories.interfaces;

import entities.User;

public interface IUserRepository {
    boolean registerUser(String username, String password, String role);
    User loginUser(String username, String password);
}
