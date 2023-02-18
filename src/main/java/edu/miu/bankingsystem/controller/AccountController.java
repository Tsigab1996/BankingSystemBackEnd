package edu.miu.bankingsystem.controller;

import edu.miu.bankingsystem.domain.Account;
import edu.miu.bankingsystem.domain.Transaction;
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
    @PostMapping("/withdraw/{id}")
    public Account withdrawFromAccountById(@PathVariable  long id,@RequestParam(value = "value") double amount){
      return accountService.withdrawFromAccountById(id, amount);
    }
    @PostMapping("/deposit/{id}")
    public Account depositIntoAccountById(@PathVariable  long id,@RequestParam(value = "value") double amount){
        return accountService.depositIntoAccountById(id,amount);
    }
}
