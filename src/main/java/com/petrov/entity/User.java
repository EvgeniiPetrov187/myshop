//package com.petrov.entity;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "users")
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "user_name")
//    private String userName;
//
//    @OneToMany(mappedBy = "user")
//    private List<Order> order;
//
//    public User() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public List<Order> getOrder() {
//        return order;
//    }
//
//    public void setOrder(List<Order> order) {
//        this.order = order;
//    }
//}
