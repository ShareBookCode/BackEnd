package com.example.sharebookbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "email", unique = true, length = 255)
    private String email;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name ="last_name", length = 100)
    private String lastName;
    @Lob
    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "profile_picture_url", length = 500)
    private String profilePictureUrl;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "phone_number", length = 30)
    private String phoneNumber;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name ="city_id",
            nullable = true, //город не обязателен
            foreignKey = @ForeignKey(name = "fk_user_city"))
    private City city;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public User(String username, String email, String firstName, String lastName){
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = null;

    }
    public User(String username, String email, String firstName, String lastName, City city){
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    public String getCityId() {
        return city != null ? city.getId() : null;

    }

    public String getCityName() {
        return city != null ? city.getName() : null;
    }
    @Override
    public String toString() {
        return "User{id='" + id + "', username='" + username + "'}";
    }
}
