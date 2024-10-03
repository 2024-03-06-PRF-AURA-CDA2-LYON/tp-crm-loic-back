package org.example.tpcrm2i.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "company_name", nullable = false, length = 100)
    String company_name;

    @Column(name = "first_name", nullable = false, length = 50)
    String first_name;

    @Column(name = "last_name", nullable = false, length = 50)
    String last_name;

    @Column(name = "email", nullable = false, length = 100)
    String email;

    @Column(name = "phone_number", unique = true, length = 15)
    String phone_number;

    @Column(name = "address", nullable = false)
    String address;

    @Column(name = "zip_code", nullable = false, length = 30)
    String zip_code;

    @Column(name = "country", nullable = false, length = 100)
    String country;

    @Column(name = "city", nullable = false, length = 100)
    String city;

    @Column(name = "state")
    int state;

    @Getter
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();

    public Customer(String company_name, String first_name, String last_name, String email, String phone_number, String address, String zip_code, String country, String city, int state) {
        this.company_name = company_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.zip_code = zip_code;
        this.country = country;
        this.city = city;
        this.state = state;
    }

    public Customer() {}

}
