package edu.miu.bankingsystem.service;



import edu.miu.bankingsystem.domain.Users;

import java.util.List;

public interface UserService {

   List<Users> getAllUsers();
     Users getAUserById(long id);
     void saveAUser(Users user);
     void deleteAUser(long id);
     Users updateAUser(long id, Users user);



     double viewSavingOrCheckingBalance(long id, String accountType);

     List<Users> getAllCUstomers();
     List<Users> getAllEmployees();

}
