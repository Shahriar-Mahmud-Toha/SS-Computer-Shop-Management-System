package dev.domain;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "actualPrice")
    private double actualPrice;

    @Column(name = "sellingPrice")
    private double sellingPrice;

    @Column(name = "name")
    private String name;

    @Column(name = "brandName")
    private String brandName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "orderCount")
    private int orderCount;

    @Column(name = "imageName")
    private String imageName;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Categories category;

    public Product() {
    }

    public Product(int id, double actualPrice, double sellingPrice, String name, String brandName, int quantity, int orderCount, String imageName, String description, Categories category) {
        this.id = id;
        this.actualPrice = actualPrice;
        this.sellingPrice = sellingPrice;
        this.name = name;
        this.brandName = brandName;
        this.quantity = quantity;
        this.orderCount = orderCount;
        this.imageName = imageName;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}
