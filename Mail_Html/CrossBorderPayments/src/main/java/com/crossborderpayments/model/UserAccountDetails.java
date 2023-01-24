package com.crossborderpayments.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountDetails {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "userName")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name= "publicKey")
    private String publicKeyValue;

    @Column(name= "privateKey")
    private String privateKeyValue;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

}
