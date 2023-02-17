package edu.miu.bankingsystem.repository;

import edu.miu.bankingsystem.domian.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
}