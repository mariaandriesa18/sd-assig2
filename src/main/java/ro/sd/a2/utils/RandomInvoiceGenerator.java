package ro.sd.a2.utils;

import ro.sd.a2.converters.DTOtoEntity;
import ro.sd.a2.entity.BankAccount;
import ro.sd.a2.entity.Companies;
import ro.sd.a2.entity.Invoice;
import ro.sd.a2.entity.User;

import java.util.List;
import java.util.Random;

public class RandomInvoiceGenerator {

    public static  Invoice generateRandomInvoice(List<BankAccount> bankAccounts, List<Companies> companies){
        Invoice bill = new Invoice();
        DTOtoEntity dtotoEntity = new DTOtoEntity();
        Random rand = new Random();
        double sum = (Math.random()*((200-100)+1))+100;

        BankAccount acc = bankAccounts.get(rand.nextInt(bankAccounts.size()));
        User randUser = acc.getUser();
        Companies co =  companies.get(rand.nextInt(companies.size()));

        bill.setInvoice_title(new String("User " + randUser.getUsername() +  " has a due bill of sum "+
                sum + " "+ co.getCurrency() +" at the "+ co.getCompany_name() + "  company."));
        bill.setBankAccount(acc);
        bill.setCompany(co);
        bill.setSum(Double.toString(sum));

        return bill;
    }
}
