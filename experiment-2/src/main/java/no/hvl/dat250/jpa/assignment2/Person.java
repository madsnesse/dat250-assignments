package no.hvl.dat250.jpa.assignment2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Setter
@Getter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "owners")
    private Collection<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "owner")
    private Collection<CreditCard> creditCards = new ArrayList<>();

}
