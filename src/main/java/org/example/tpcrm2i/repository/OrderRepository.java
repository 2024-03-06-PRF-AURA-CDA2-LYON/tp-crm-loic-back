package org.example.tpcrm2i.repository;

import org.example.tpcrm2i.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
