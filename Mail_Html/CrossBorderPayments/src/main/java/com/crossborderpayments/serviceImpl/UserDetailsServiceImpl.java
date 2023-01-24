package com.crossborderpayments.serviceImpl;

import com.crossborderpayments.dto.UserDetailsDto;
import com.crossborderpayments.mapper.UserDetailsMapper;
import com.crossborderpayments.model.UserAccountDetails;
import com.crossborderpayments.repository.UserDetailsRepository;
import com.crossborderpayments.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsMapper userDetailsMapper;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public String save(UserDetailsDto userDetailsDto) {

        UserAccountDetails userAccountDetails=userDetailsMapper.map(userDetailsDto);

        userDetailsRepository.save(userAccountDetails);

        return "User Details are saved in database";
    }
}
