package frank.userapp.service;

import frank.userapp.model.User;
import frank.userapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public User updateUser(Long id, User user) {
        return userRepository.updateUser(id, user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
