package edu.miu.bankingsystem.service;

import edu.miu.bankingsystem.domian.Account;

import java.util.List;

public interface AccountService {
  public List<Account>  getAllAccounts();
  public Account getAnAccountByID(long id);
  public void saveAnAccount(Account account);
  public void deleteAnAccount(long id);
  public Account updateAnAccount(long id, Account account);
}
