package org.example.tpcrm2i.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "company_name")
    String company_name;
    @Column(name = "first_name")
    String first_name;
    @Column(name = "last_name")
    String last_name;
    @Column(name = "email")
    String email;
    @Column(name = "phone_number")
    String phone_number;
    @Column(name = "address")
    String address;
    @Column(name = "zip_code")
    String zip_code;
    @Column(name = "country")
    String country;
    @Column(name = "city")
    String city;
    @Column(name = "state")
    int state;

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
