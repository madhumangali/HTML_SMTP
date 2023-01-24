package com.crossborderpayments.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {

    private String userName;

    private String password;

    private String email;

    private String publicKeyValue;

    private String privateKeyValue;

}
