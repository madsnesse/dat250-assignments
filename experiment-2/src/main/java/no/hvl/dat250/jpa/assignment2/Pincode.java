package no.hvl.dat250.jpa.assignment2;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pincode;
    private Integer count;

    public Long getId() {
        return id;
    }

    public String getPincode() {
        return pincode;
    }

    public Integer getCount() {
        return count;
    }
}
