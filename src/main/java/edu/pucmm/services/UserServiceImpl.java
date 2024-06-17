package edu.pucmm.services;

import edu.pucmm.data.User;
import edu.pucmm.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean validateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User userDB = getUserById(user.getId());
        if (userDB == null) {
            return null;
        }
        userDB.setUsername(user.getUsername());
        userDB.setPassword(user.getPassword());
        return userRepository.save(userDB);
    }

    @Override
    public void deleteUser(Long id) {
        User userDB = getUserById(id);
        if (userDB != null) {
            userRepository.delete(userDB);
        }
    }
}
