package edu.miu.bankingsystem.controller;


import edu.miu.bankingsystem.domian.Users;
import edu.miu.bankingsystem.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")

    public Users getAUserById(@PathVariable long id){
        return userService.getAUserById(id);
    }

    @PostMapping

    public void saveAUser(@RequestBody Users user){
        userService.saveAUser(user);
    }
    @DeleteMapping("/{id}")

    public void deleteAUser(@PathVariable long id){
        userService.deleteAUser(id);
    }

    @PutMapping("{id}")

    public void updateAUser(@PathVariable long id, @RequestBody Users user){
        userService.updateAUser(id, user);
    }
}
