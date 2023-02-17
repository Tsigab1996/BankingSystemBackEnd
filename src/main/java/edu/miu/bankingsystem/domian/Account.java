package edu.miu.bankingsystem.domian;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String accountNumber;
    private double balance;
    private LocalDate createdAt;
    private String accountType;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonIgnoreProperties("accounts")
    private Users users;

    @OneToMany(mappedBy = "account" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("account")
    private List<Transaction> transactions;

}
