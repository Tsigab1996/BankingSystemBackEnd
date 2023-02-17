package edu.miu.bankingsystem.service.imp;

import edu.miu.bankingsystem.domian.Account;
import edu.miu.bankingsystem.domian.Customer;
import edu.miu.bankingsystem.repository.AccountRepo;
import edu.miu.bankingsystem.repository.CustomerRepo;
import edu.miu.bankingsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService {
    private final AccountRepo accountRepo;


    @Autowired
    private CustomerRepo customerRepo;





    public AccountServiceImp(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public Account getAnAccountByID(long id) {
        return accountRepo.findById(id).get();
    }

    @Override
    public void saveAnAccount(Account account) {
     accountRepo.save(account);
    }

    @Override
    public void deleteAnAccount(long id) {
     accountRepo.deleteById(id);
    }

    @Override
    public Account updateAnAccount(long id, Account account) {
     Account a= new Account();
     a.setId(id);
     Account acct= accountRepo.save(a);
     return acct;
    }

    @Override
    public Double viewBalance(long id) {
        Optional<Customer> c = customerRepo.findById(id);
        List<Account> customerAcc = c.get().getAccounts();
       double sumBalance= customerAcc.stream().map(b->b.getBalance()).mapToDouble(s -> s).sum();

        return sumBalance;
    }


}
