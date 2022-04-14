package kz.nurlan.oibekuly.repository;
import kz.nurlan.oibekuly.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

    Optional<Customers> findCustomerByAddress(String address);

    List<Customers> findByFirstnameEndsWith(String firstname);

    List<Customers> findByAge(int age);

    @Transactional(timeout = 10)
    List<Customers> selectStudentWhereFirstNameAndAgeGreaterOrEqual(
            String firstname, int age);


    @Transactional(timeout = 10)
    List<Customers> selectCustomerWhereFirstNameAndAgeGreaterOrEqualNative(
            @Param("firstname") String firstname,
            @Param("age") Integer age);

    @Transactional
    public void deleteCustomerById(Integer customer_id);

    @Transactional(timeout = 10)
    List<Customers> findAll();

    @Transactional(timeout = 10)
    List<Customers> findByLastname(@Param("lastname") String lastname);
}
