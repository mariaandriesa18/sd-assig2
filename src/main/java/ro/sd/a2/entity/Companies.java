package ro.sd.a2.entity;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Companies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer company_id;

    @Column
    private String company_name;

    @Column
    private String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Companies(){}

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }


}
