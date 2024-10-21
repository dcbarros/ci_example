package com.api.teste.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "product_name", nullable = false, length = 22)
    private String productName;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false, precision = 7, scale = 2)
    private BigDecimal price;

    @Column(name = "customer_name", nullable = false, length = 50)
    private String customerName;

    @Column(name = "shipping_address", nullable = false, length = 50)
    private String shippingAddress;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "payment_method", nullable = false, length = 16)
    private String paymentMethod;

    @Column(name = "status", nullable = false, length = 10)
    private String status;

    public Order(String productName, Integer quantity, BigDecimal price, String customerName, String shippingAddress,
            LocalDate orderDate, String paymentMethod) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.status = "pending";
    }

    public Order() {
    }

    
}
