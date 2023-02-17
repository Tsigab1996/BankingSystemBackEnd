package edu.miu.bankingsystem.controller;

import edu.miu.bankingsystem.domian.Account;
import edu.miu.bankingsystem.domian.Transaction;
import edu.miu.bankingsystem.service.AccountService;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("api/v1/accounts")
@CrossOrigin
public class AccountController {

    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts(){
        List<Account> a = accountService.getAllAccounts();
        System.out.println("was here " + a.size());
        return a;
    }
    @GetMapping("/get/{id}")

    public Account getAccountById(@PathVariable  long id){
        return accountService.getAnAccountByID(id);
    }
    @PostMapping("/withdraw/{accountId}/{amount}")
    public Account withdrawFromAccountById(@PathVariable  long accountId,@PathVariable Double amount){
        Account a = accountService.getAnAccountByID(accountId);
        a.setBalance(a.getBalance() - amount);
        a.getTransactions().add(new Transaction(null, LocalDate.now(), amount, "withdraw", a));
        accountService.saveAnAccount(a);
        return a;
    }
    @PostMapping("/deposit/{accountId}/{amount}")
    public Account depositIntoAccountById(@PathVariable  long accountId,@PathVariable Double amount){
        Account a = accountService.getAnAccountByID(accountId);
        a.setBalance(a.getBalance() + amount);
        a.getTransactions().add(new Transaction(null, LocalDate.now(), amount, "deposit", a));
        accountService.saveAnAccount(a);
        return a;
    }

    @PostMapping
    public void saveAnAccount(@RequestBody Account account){
        accountService.saveAnAccount(account);
    }

    @DeleteMapping("/delete/{id}")

    public void deleteAnAccount(@PathVariable long id){
        accountService.deleteAnAccount(id);
    }

    @PutMapping("/update/{id}")
    public void updateAnAccount(@PathVariable long id, @RequestBody Account account){
        accountService.updateAnAccount(id, account);
    }
}
