package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.entity.BankAccount;
import ro.sd.a2.entity.Companies;
import ro.sd.a2.entity.Invoice;
import ro.sd.a2.repository.InvoiceRepository;
import ro.sd.a2.utils.RandomInvoiceGenerator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private BankAccountService bankaccountService;
    @Autowired
    private CompaniesService companiesService;

    @Transactional
    public void generateXRandomInvoices(int nbOfInvoices){

        List<BankAccount> bankAccounts = bankaccountService.getAllBankaccounts();
        List<Companies> companies = companiesService.getAllCompanies();
        List<Invoice> invoices = new ArrayList<>();

        for(int i = 0; i < nbOfInvoices; i++){
            Invoice bill = RandomInvoiceGenerator.generateRandomInvoice(bankAccounts,companies);
            //invoices.add(bill);
            invoiceRepository.save(bill);
        }

    }

}
