package edu.miu.bankingsystem.service.imp;


import edu.miu.bankingsystem.domain.Account;


import edu.miu.bankingsystem.domain.Transaction;

import edu.miu.bankingsystem.repository.AccountRepo;
import edu.miu.bankingsystem.service.AccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AccountServiceImp implements AccountService {
    LocalTime now = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formattedTime = now.format(formatter);

    public static long value=1;

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
    public Account updateAnAccount(long id, Account account) {
     Account a= getAnAccountByID(id);
     a.setBalance(account.getBalance());
     Account acct= accountRepo.save(a);
     return acct;
    }

    @Override
    public Account withdrawFromAccountById(long id, double amount) {
        Account a = getAnAccountByID(id);
        a.setBalance(a.getBalance() - amount);
        a.getTransactions().add(new Transaction( value,LocalDate.now(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS), amount, "withdraw", a, a.getBalance()));
        value++;
        saveAnAccount(a);
        return a;
    }

    @Override
    public Account depositIntoAccountById(long id, double amount) {

        Account a = getAnAccountByID(id);
        a.setBalance(a.getBalance() + amount);
        a.getTransactions().add(new Transaction(value, LocalDate.now(),  LocalTime.now().truncatedTo(ChronoUnit.SECONDS), amount, "deposit", a, a.getBalance()));
        value++;
        saveAnAccount(a);
        return a;
    }

}
