package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
