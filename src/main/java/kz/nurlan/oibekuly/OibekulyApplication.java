package kz.nurlan.oibekuly;
import kz.nurlan.oibekuly.model.Customers;
import kz.nurlan.oibekuly.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
public class OibekulyApplication {

    @Autowired
    public  static CustomersRepository customersRepository;

    public static void main(String[] args) {
        SpringApplication.run(OibekulyApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(CustomersRepository customersRepository) {
        return args -> {

            Customers diaz = new Customers(   19,"Diaz", "Johnson", 28, "Alabama");

            List<Customers> customersList = customersRepository.findAll();
            customersList.forEach(System.out::println);

            customersRepository.save(diaz);

            List<Customers> customersList2 = customersRepository.findAll();
            customersList2.forEach(System.out::println);

            customersRepository.delete(diaz);

            List<Customers> customersByLastname = customersRepository.findByFirstnameEndsWith("SCOTT");
            customersByLastname.forEach(System.out::println);

            List<Customers> customersByFirstnameEndsWith = customersRepository.findByFirstnameEndsWith("r");
            customersByFirstnameEndsWith.forEach(System.out::println);

            List<Customers> customersByAge = customersRepository.findByAge(19);
            customersByAge.forEach(System.out::println);
            customersRepository
                    .findById(4)
                    .ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Customer with ID 4 not found"));

            customersRepository.findCustomerByAddress("New York").ifPresentOrElse(
                    System.out::println,
                            () -> System.out.println("Customer with such address not found")
            );
        };
    }
}


