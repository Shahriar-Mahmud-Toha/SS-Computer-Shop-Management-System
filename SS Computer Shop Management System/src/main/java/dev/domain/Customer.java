package dev.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "otp")
    private String otp;

    @Column(name = "totalProfit")
    private Double totalProfit;

    @Column(name = "tempTotalProfit")
    private Double tempTotalProfit;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String email, String name, String password, String otp, Double totalProfit, Double tempTotalProfit, List<Order> orders) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.otp = otp;
        this.totalProfit = totalProfit;
        this.tempTotalProfit = tempTotalProfit;
        this.orders = orders;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Double totalProfit) {
        this.totalProfit = totalProfit;
    }

    public Double getTempTotalProfit() {
        return tempTotalProfit;
    }

    public void setTempTotalProfit(Double tempTotalProfit) {
        this.tempTotalProfit = tempTotalProfit;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
