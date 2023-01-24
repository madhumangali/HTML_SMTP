package com.crossborderpayments.mapper;

import com.crossborderpayments.dto.UserDetailsDto;
import com.crossborderpayments.model.UserAccountDetails;
import org.mapstruct.Mapper;

@Mapper
public interface UserDetailsMapper {

    public UserAccountDetails map(UserDetailsDto userDetailsDto);

}
