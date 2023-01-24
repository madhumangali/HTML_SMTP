package com.example.Html_Demo.controller;

import com.example.Html_Demo.model.Password;
import com.example.Html_Demo.model.UserAccountDetails;
import com.example.Html_Demo.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SampleController {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @GetMapping("/")
    public String hello(@Param(value = "token") String token,Model model) throws Exception {

        UserAccountDetails userAccountDetails= userDetailsRepository.resetPasswordToken(token);

        if(userAccountDetails == null){
           return "LinkExpire";
        }else{
            model.addAttribute("token",token);

            return "index";
        }


    }

    @PostMapping("/reset")
    public String reset(HttpServletRequest request, Model model) throws Exception {
        String token=request.getParameter("token");
        String password=request.getParameter("confirmNewPassword");
       UserAccountDetails userAccountDetails= userDetailsRepository.resetPasswordToken(token);

           userAccountDetails.setPassword(password);
           userAccountDetails.setResetPasswordToken(null);
           userDetailsRepository.save(userAccountDetails);

        return "passwordChanged";
    }

}
