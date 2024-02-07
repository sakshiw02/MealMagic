package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
// user class
public class User extends BaseEntity {

    @Column(length = 20, name = "user_name")
    private String userName;

    @Column(length = 30, name = "user_email")
    private String userEmail;

    @Column(length = 10, name = "user_contact")
    private String userContact;

    @Column(name = "user_city")
    private String userCity;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate userJoinDt;

    private double userBudget;

    @Column(name = "user_password") // Assuming it's a password field
    private String userPassword;

    // Unidirectional one-to-many relationship: User to Booking
    @ElementCollection
    @CollectionTable(name = "user_bookings", joinColumns = @JoinColumn(name = "user_id"))
    private List<Booking> bookings = new ArrayList<>();

    public User(String userName, String userEmail, String userContact, String userCity, double userBudget,
            List<Booking> bookings) {
        super();
        this.userName = userName;
        this.userEmail = userEmail;
        this.userContact = userContact;
        this.userCity = userCity;
        this.userBudget = userBudget;
        this.bookings = bookings;
    }
}
