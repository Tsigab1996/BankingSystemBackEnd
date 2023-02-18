package edu.miu.bankingsystem.service.imp;



import edu.miu.bankingsystem.domain.Account;
import edu.miu.bankingsystem.domain.Users;


import edu.miu.bankingsystem.repository.UserRepo;
import edu.miu.bankingsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    Users u=  getAUserById(id);
    u.setFirstName(user.getFirstName());
    u.setLastName(user.getLastName());
    u.setEmail(user.getEmail());
    u.setPassword(user.getPassword());
    u.setPhoneNumber(user.getPhoneNumber());
    Users newUser= userRepo.save(u);
    return newUser;
    }

    @Override
    public Double viewBalance(long id) {
        Optional<Users> c = userRepo.findById(id);
        List<Account> customerAcc = c.get().getAccounts();
        double sumBalance= customerAcc.stream().map(b->b.getBalance()).mapToDouble(s -> s).sum();
        return sumBalance;
    }

    @Override
    public double viewSavingOrCheckingBalance(long id, String accountType) {
        double totalSavingBalance= 0;
        Optional<Users> c = userRepo.findById(id);
        List<Account> customerAcc = c.get().getAccounts();
        for (int i = 0; i < customerAcc.size(); i++) {
            if(customerAcc.get(i).getAccountType().equals(accountType)){
                totalSavingBalance= customerAcc.get(i).getBalance();
                break;
            }
        }
        return totalSavingBalance;
    }


}
