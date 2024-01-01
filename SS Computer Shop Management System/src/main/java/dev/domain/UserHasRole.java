//package dev.domain;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "user_has_roles")
//public class UserHasRole {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "email", nullable = false)
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id", nullable = false)
//    private Role role;
//
//    public UserHasRole() {
//    }
//
//    public UserHasRole(Long id, User user, Role role) {
//        this.id = id;
//        this.user = user;
//        this.role = role;
//    }
//
//    public UserHasRole(String email, Long roleId) {
//        this.user = new User(email); // Create a new User object
//        this.role = new Role(roleId); // Create a new Role object (assuming ID-based Role constructor)
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
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//}
