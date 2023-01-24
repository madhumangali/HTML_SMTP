package com.crossborderpayments.repository;

import com.crossborderpayments.model.UserAccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserAccountDetails , Long> {

//    UserAccountDetails emailId(String emailId);

    UserAccountDetails email(String emailId);
}
