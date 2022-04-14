package kz.nurlan.oibekuly.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Scope("prototype")
@Component
@Entity(name = "customers")
@Table(name = "customers")
public class Customers  {

    @Id
    @Column(name = "customer_id")
    public Integer customer_id;

    @Column(name = "firstname")
    public String firstname;

    @Column(name = "lastname")
    public String lastname;

    @Column(name = "age")
    public int age;

    @Column(name = "address")
    public String address;

    public Customers(Integer customer_id, String firstname, String lastname, int age, String address) {
        this.customer_id = customer_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.address = address;
    }

}
