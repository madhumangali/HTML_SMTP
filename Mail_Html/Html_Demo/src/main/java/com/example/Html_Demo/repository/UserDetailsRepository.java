package com.example.Html_Demo.repository;

import com.example.Html_Demo.model.UserAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserAccountDetails, Long> {

    UserAccountDetails email(String emailId);

    UserAccountDetails resetPasswordToken(String token);

}
