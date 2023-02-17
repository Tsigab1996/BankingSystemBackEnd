package edu.miu.bankingsystem.service.imp;


import edu.miu.bankingsystem.domian.Account;
import edu.miu.bankingsystem.domian.Users;
import edu.miu.bankingsystem.repository.AccountRepo;
import edu.miu.bankingsystem.repository.UserRepo;
import edu.miu.bankingsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepo userRepo;
    private final AccountRepo accountRepo;
    //Optional<Account> acc= new Account();

    public UserServiceImp(UserRepo userRepo, AccountRepo accountRepo) {
        this.userRepo = userRepo;
        this.accountRepo = accountRepo;
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
    public Users getAUserBalanceById(long id) {
        Users user=userRepo.findById(id).orElse(null);
        if (user != null) {
            Optional<Account> account = accountRepo.findById(id);
            //acc= account;
//            user.setAccounts(account.s);
            account.stream().map(x->x.getBalance());
        }
        return user;
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
