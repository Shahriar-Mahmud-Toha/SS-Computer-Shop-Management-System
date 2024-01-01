package dev.domain;

import javax.persistence.*;

@Entity
@Table(name = "customerprofit")
public class CustomerProfit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Add this for auto-generated ID
    private Long id;

    @Column(name = "cusEmail", nullable = false)
    private String customerEmail;

    @Column(name = "totalProfit", nullable = false, columnDefinition = "int default 0")  // Ensure default value
    private int totalProfit;

    public CustomerProfit() {
    }

    public CustomerProfit(String customerEmail, int totalProfit) {
        this.customerEmail = customerEmail;
        this.totalProfit = totalProfit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(int totalProfit) {
        this.totalProfit = totalProfit;
    }
}


