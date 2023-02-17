package edu.miu.bankingsystem.repository;


import edu.miu.bankingsystem.domian.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {

}
