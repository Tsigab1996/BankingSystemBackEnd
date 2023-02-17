package edu.miu.bankingsystem.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate transactionDate;
    private double amount;
    private String transactionType;


    @ManyToOne
    @JsonBackReference
    private Account account;

    //This is a parameterized constructor.....
    public Transaction( LocalDate local, Double amount, String withdraw, Account a) {
        this.transactionDate=local;
        this.amount=amount;
        this.transactionType=withdraw;
        this.account=a;
    }
}