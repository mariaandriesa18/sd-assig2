package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.entity.BankAccount;
import ro.sd.a2.repository.BankAccountRepository;

import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    BankAccountRepository bankAccountRepository;

    public List<BankAccount> getAllBankaccounts(){
        return bankAccountRepository.findAll();
    }

}
