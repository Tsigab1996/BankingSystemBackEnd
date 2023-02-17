package edu.miu.bankingsystem.controller;


import edu.miu.bankingsystem.domian.Users;
import edu.miu.bankingsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get/{id}")

    public Users getAUserById(@PathVariable long id){
        return userService.getAUserById(id);
    }

    @PostMapping

    public void saveAUser(@RequestBody Users user){
        userService.saveAUser(user);
    }
    @DeleteMapping("/delete/{id}")

    public void deleteAUser(@PathVariable long id){
        userService.deleteAUser(id);
    }

    @PutMapping("/update/{id}")

    public void updateAUser(@PathVariable long id, @RequestBody Users user){
        userService.updateAUser(id, user);
    }

    @GetMapping("/viewBalance/{customerID}")
    public Double viewBalance(@PathVariable long customerID){
        return userService.viewBalance(customerID);

    }
    @GetMapping("/viewCheckingOrCheckingBalance{customer_Id}")
    public double viewSavingOrCheckingBalance(@PathVariable long id, @RequestParam(value = "accountType") String accountType){
        return userService.viewSavingOrCheckingBalance(id, accountType);
    }
}
