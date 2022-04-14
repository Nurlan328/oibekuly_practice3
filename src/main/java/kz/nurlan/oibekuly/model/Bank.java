
package kz.nurlan.oibekuly.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@Scope("prototype")
@Component
@Entity(name = "bank")
@Table(name = "bank")
public class Bank {

    @Id
    @Column(name = "bank_id")
    private int bank_id;

    @Column(name = "bankname")
    private String bankname;

    @Column(name = "customer_account_number")
    private Long customer_account_number;

    public Bank(int bank_id, String bankName, Long customer_account_number) {
        this.bank_id = bank_id;
        this.bankname = bankName;
        this.customer_account_number = customer_account_number;
    }
}