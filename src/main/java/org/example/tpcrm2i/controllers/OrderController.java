package org.example.tpcrm2i.controllers;

import org.example.tpcrm2i.entities.Customer;
import org.example.tpcrm2i.entities.Order;
import org.example.tpcrm2i.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.sql.Types.NULL;

@SpringBootApplication
@RestController
@RequestMapping(value = "/orders", produces = "application/json")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getOrders() {
        return this.orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return this.orderRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        this.orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        this.orderRepository.deleteById(id);
    }

    // TODO: implement the correct return after update (WIP)
    @PutMapping("/{id}")
    public Customer updateOrderById(@PathVariable Long id, @RequestBody Order order) {
        Optional<Order> orderPut = this.orderRepository.findById(id);
        orderPut.get().setService_type(order.getService_type() != null ? order.getService_type() : orderPut.get().getService_type());;
        orderPut.get().setTva(order.getTva() != null ? order.getTva() : orderPut.get().getTva());
        orderPut.get().setCustomer(order.getCustomer() != null ? order.getCustomer() : orderPut.get().getCustomer());
        orderPut.get().setNb_days(order.getNb_days() != NULL ? order.getNb_days() : orderPut.get().getNb_days());
        orderPut.get().setTotal_exclude_tax(order.getTotal_exclude_tax() != NULL ? order.getTotal_exclude_tax() : order.getTotal_exclude_tax());
        orderPut.get().setState(order.getState() != NULL ? order.getState() : orderPut.get().getState());
        orderPut.get().setComment(order.getComment() != null ? order.getComment() : orderPut.get().getComment());
        return this.orderRepository.save(orderPut.get()).getCustomer();
    }

}
