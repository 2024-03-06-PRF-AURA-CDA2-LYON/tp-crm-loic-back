package org.example.tpcrm2i.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "service_type", nullable = false, length = 100)
    String service_type;

    @Column(name = "tva", nullable = false)
    Double tva;

    @Column(name = "nb_days", nullable = false)
    int nb_days;

    @Column(name = "total_exclude_tax", nullable = false)
    int total_exclude_tax;

    @Column(name = "state")
    int state;

    @Column(name = "comment")
    String comment;

    @ManyToOne
    @JoinColumn(name = "customer", nullable = false)
    private Customer customer;

    public Order(int id, String service_type, Double tva, int nb_days, int total_exclude_tax, int state, String comment, Customer customer) {
        this.id = id;
        this.service_type = service_type;
        this.tva = tva;
        this.nb_days = nb_days;
        this.total_exclude_tax = total_exclude_tax;
        this.state = state;
        this.comment = comment;
        this.customer = customer;
    }

    public Order() {}
}
