package no.hvl.dat250.jpa.assignment2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;
    private Integer balance;
    private Integer limit;

    @ManyToOne
    @JoinColumn(name = "owningbank_id")
    private Bank owningBank;
    @OneToOne
    private Pincode pincode;

}
