package edu.miu.bankingsystem.service;



import edu.miu.bankingsystem.domian.Users;

import java.util.List;

public interface UserService {

    public List<Users> getAllUsers();
    public Users getAUserById(long id);
    public void saveAUser(Users user);
    public void deleteAUser(long id);
    public Users updateAUser(long id, Users user);
}
