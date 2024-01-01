//package dev.domain;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "roles")
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name")
//    private String name;
//
//    public Role() {
//    }
//
//    public Role(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Role(Long roleId) {
//        this.id = roleId;
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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
