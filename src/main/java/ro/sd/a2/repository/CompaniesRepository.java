package ro.sd.a2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.sd.a2.entity.Companies;

import java.util.List;

@Repository
public interface CompaniesRepository extends JpaRepository<Companies, Integer> {

    @Query("SELECT c FROM Companies c")
    List<Companies> getAllCompanies();

    @Query("SELECT c FROM Companies c where c.company_name = :company_name")
    Companies findCompaniesByCompany_name(@Param("company_name") String company_name);
}
