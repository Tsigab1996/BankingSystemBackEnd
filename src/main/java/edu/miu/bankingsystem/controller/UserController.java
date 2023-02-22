package edu.miu.bankingsystem.controller;


import edu.miu.bankingsystem.domain.Users;
import edu.miu.bankingsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin
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

    @PostMapping("/save")

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


    @GetMapping("/filter/{id}")
    public double viewSavingOrCheckingBalance(@PathVariable long id, @RequestParam(value = "value") String accountType){
        return userService.viewSavingOrCheckingBalance(id, accountType);
    }


    @GetMapping("/customers")
    public List<Users> getAllCustomers(){
        return userService.getAllCUstomers();
    }

    @GetMapping("/bankers")
    public List<Users> getOwners(){
        return userService.getAllEmployees();
    }
}
