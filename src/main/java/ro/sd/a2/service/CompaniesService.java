package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.entity.Companies;
import ro.sd.a2.repository.BankAccountRepository;
import ro.sd.a2.repository.CompaniesRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompaniesService {
    @Autowired
    private CompaniesRepository companiesRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Transactional
    public List<Companies> getAllCompanies() {
        return companiesRepository.getAllCompanies();
    }

    @Transactional
    public void addNewCompany(String company_name, String currency){
        Companies c = new Companies();
        c.setCompany_name(company_name);
        c.setCurrency(currency);
        companiesRepository.save(c);
    }

    @Transactional
    public Companies getCompanyByCompanyName(String companyName){
        return companiesRepository.findCompaniesByCompany_name(companyName);
    }

}
