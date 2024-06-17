package edu.pucmm.services;

import edu.pucmm.data.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public List<User> listAllUser();
    public User getUserById(Long id);
    public boolean validateUser(String username, String password);

    public User createUser(User user);
    public User updateUser(User user);
    public void deleteUser(Long id);

}
