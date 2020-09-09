package ro.sd.a2.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name="invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoice_id;

    @Column
    private String invoice_title;

    @Column
    private String  sum;

    @ManyToOne
    @JoinColumn(name="bankaccount_id")
    private BankAccount bankAccount;

    @ManyToOne
    @JoinColumn(name="company_id")
    private Companies company;

    public Invoice() {
    }

    public Integer getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getInvoice_title() {
        return invoice_title;
    }

    public void setInvoice_title(String invoice_title) {
        this.invoice_title = invoice_title;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    @Entity
    @Table(name="transaction")
    public static class Transaction {

        @Id
        @GeneratedValue
        private Integer transaction_id;

        @Column
        private Double amount;

        @Column
        private LocalDateTime transaction_date;

    }
}
