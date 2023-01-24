package com.crossborderpayments.service;

import com.crossborderpayments.dto.UserDetailsDto;
import com.crossborderpayments.model.UserAccountDetails;

public interface UserDetailsService {

    public String save(UserDetailsDto userDetailsDto);
}
