
package kz.nurlan.oibekuly.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Scope("prototype")
@Component
@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "account_id")
    public Integer account_id;

    @Column(name = "accountnumber")
    public Long accountnumber;

    @Column(name = "balance")
    public double balance;

    @Column(name = "interest")
    private double interest;
}
