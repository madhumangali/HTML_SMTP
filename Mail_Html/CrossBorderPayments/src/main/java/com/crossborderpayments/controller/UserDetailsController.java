package com.crossborderpayments.controller;

import com.crossborderpayments.dto.UserDetailsDto;
import com.crossborderpayments.service.UserDetailsService;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Vinay_Mamidisetti And Prasanth
 */

@RestController
@RequestMapping("/userDetails")
@Log4j2
public class UserDetailsController {

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping(value = "/save")
    public ResponseEntity<?> getTablesList( @RequestBody UserDetailsDto userDetailsDto) throws Exception {

        ResponseEntity<?> response = new ResponseEntity<>(userDetailsService.save(userDetailsDto), HttpStatus.OK);
        return response;

    }


}
