package edu.miu.bankingsystem.service.imp;

import edu.miu.bankingsystem.domian.User;
import edu.miu.bankingsystem.repository.UserRepo;
import edu.miu.bankingsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {

    private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getAUserById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void saveAUser(User user) {
     userRepo.save(user);
    }

    @Override
    public void deleteAUser(long id) {
     userRepo.deleteById(id);
    }

    @Override
    public void updateAUser(long id, User user) {
    userRepo.save(user);
    }
}
