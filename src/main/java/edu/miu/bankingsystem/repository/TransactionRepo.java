package edu.miu.bankingsystem.repository;

import edu.miu.bankingsystem.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    //This is just to find the transactions using an account Id only
//    public List<Transaction> findAllByAccount_Id(long id);
//
//    //This is also JPQL to find the transactions using an account Id only
//    @Query("select t from Transaction t join t.account acct where acct.id=:id")
//    public List<Transaction> getAllTransactions(long id);

    //This is a jpql to find the transactions of a specific customer
    @Query("select t from Transaction t join t.account acct join acct.users u where u.id=:a and acct.id=:b ")
    public List<Transaction> getAllTransactionsByUserByAccount(long a, long b);

}
