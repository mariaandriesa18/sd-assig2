package ro.sd.a2.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="bankaccount")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bankaccount_id;

    @Column
    private String IBAN;

    @Column(name="account_type")
    private String account_type;

    @Column
    private String currency;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "bankAccount")
    List<Invoice> invoices;

    public BankAccount(){}

    public Integer getBankaccount_id() {
        return bankaccount_id;
    }

    public void setBankaccount_id(Integer account_id) {
        this.bankaccount_id = account_id;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getType() {
        return account_type;
    }

    public void setType(String type) {
        this.account_type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

