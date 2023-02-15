package edu.miu.bankingsystem.service.imp;

import edu.miu.bankingsystem.domian.Account;
import edu.miu.bankingsystem.repository.AccountRepo;
import edu.miu.bankingsystem.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImp implements AccountService {
    private final AccountRepo accountRepo;

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
    public void updateAnAccount(long id, Account account) {
     accountRepo.save(account);
    }
}
