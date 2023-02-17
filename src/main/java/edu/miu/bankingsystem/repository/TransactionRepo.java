package edu.miu.bankingsystem.repository;

import edu.miu.bankingsystem.domian.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByAccount_Id(long id);
}
