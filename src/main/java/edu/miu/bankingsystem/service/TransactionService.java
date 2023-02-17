package edu.miu.bankingsystem.service;

import edu.miu.bankingsystem.domian.Transaction;

import java.util.List;

public interface TransactionService {

    public List<Transaction> getAllTransactions();
    public Transaction getATransactionById(long id);
    public void saveATransaction(Transaction transaction);
    public void deleteATransaction(long id);
    public Transaction updateATransaction(long id, Transaction transaction);
}
