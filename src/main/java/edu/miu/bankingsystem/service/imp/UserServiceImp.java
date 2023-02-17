package edu.miu.bankingsystem.service.imp;


import edu.miu.bankingsystem.domain.Users;
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
    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Users getAUserById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void saveAUser(Users user) {
     userRepo.save(user);
    }

    @Override
    public void deleteAUser(long id) {
     userRepo.deleteById(id);
    }

    @Override
    public Users updateAUser(long id, Users user) {
    Users u= new Users();
    u.setId(id);
    Users newUser= userRepo.save(u);
    return newUser;
    }
}
