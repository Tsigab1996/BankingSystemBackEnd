package edu.miu.bankingsystem.controller;

import edu.miu.bankingsystem.domian.Account;
import edu.miu.bankingsystem.domian.Transaction;
import edu.miu.bankingsystem.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
@CrossOrigin
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }
    @GetMapping("/get/{id}")

    public Account getAccountById(@PathVariable  long id){
        return accountService.getAnAccountByID(id);
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
    @PostMapping("/withdraw/{accountId}")
    public Account withdrawFromAccountById(@PathVariable  long accountId,@RequestParam(value = "amount") Double amount){
        Account a = accountService.getAnAccountByID(accountId);
        a.setBalance(a.getBalance() - amount);
        a.getTransactions().add(new Transaction( LocalDate.now(), amount, "withdraw", a));
        accountService.saveAnAccount(a);
        return a;
    }
    @PostMapping("/deposit/{accountId}/{amount}")
    public Account depositIntoAccountById(@PathVariable  long accountId,@RequestParam(value = "amount") Double amount){
        Account a = accountService.getAnAccountByID(accountId);
        a.setBalance(a.getBalance() + amount);
        a.getTransactions().add(new Transaction( LocalDate.now(), amount, "deposit", a));
        accountService.saveAnAccount(a);
        return a;
    }
}
