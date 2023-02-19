package edu.miu.bankingsystem.repository;


import edu.miu.bankingsystem.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {


    //This is to find all customers
    @Query(value = "select u from Users u join u.role r where r.roleName='CUSTOMER'")
    public List<Users> getAllCUstomers();

    //This is to find all owners

    @Query(value = "select u from Users u join u.role r where r.roleName='BANKER'")
    public List<Users> getAllEmployees();
}
