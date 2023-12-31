package dev.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orId")
    private int orId;

    @Column(name = "status")
    private String status;

    @Column(name = "time")
    private LocalDate time=LocalDate.now();

    @Column(name = "shipingAddress")
    private String shipingAddress;

    @Column(name = "paymentStatus")
    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "cusEmail")
    private Customer customer;


}
