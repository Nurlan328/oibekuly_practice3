 package kz.nurlan.oibekuly.repository;

import kz.nurlan.oibekuly.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


 @Repository
 @Transactional
public interface BankRepository extends JpaRepository<Bank, Long> {

}
