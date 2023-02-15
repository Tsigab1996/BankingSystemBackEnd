package edu.miu.bankingsystem.service;

import edu.miu.bankingsystem.domian.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public User getAUserById(long id);
    public void saveAUser(User user);
    public void deleteAUser(long id);
    public void updateAUser(long id, User user);
}
