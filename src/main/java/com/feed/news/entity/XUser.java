package com.feed.news.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.feed.news.validation.PasswordsEqualConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "user_table")
public class XUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int user_id;

    @Column(name="full_name")
    private String full_name;

    @Column(name = "email" ,unique = true)
    @Email(message = "*Please provide a valid Email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    private String password;

    @Column(name = "confirm_password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    private String confirm_password;

    @Transient
    private final static String DELIMITER = ":";

    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private Set<News> news;

    public XUser(String full_name, String email, String password, Set<News> news) {
        this.full_name=full_name;
        this.email=email;
        this.password=password;
        this.news=news;

    }
}