package frank.userapp.repository;

import frank.userapp.model.User;

import java.util.List;

public interface UserRepository {

    User createUser(User user);

    User getUserById(Long id);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    List<User> getAllUsers();
}
