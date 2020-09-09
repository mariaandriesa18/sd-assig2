package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.sd.a2.entity.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

    @Query("SELECT u from BankAccount u where u.bankaccount_id = :bankaccount_id")
    BankAccount getBankAccountByBankaccount_id(@Param("bankaccount_id")Integer bankaccount_id);
}
