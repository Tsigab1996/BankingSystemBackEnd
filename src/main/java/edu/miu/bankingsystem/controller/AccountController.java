package edu.miu.bankingsystem.controller;

import edu.miu.bankingsystem.domian.Account;
import edu.miu.bankingsystem.service.AccountService;
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
