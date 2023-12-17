package com.example.springmodels.controllers;

import com.example.springmodels.models.modelUser;
import com.example.springmodels.models.roleEnum;
import com.example.springmodels.repos.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class registrationController {
    @Autowired
    private com.example.springmodels.repos.userRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/registration")
    private String RegView()
    {
        return "regis";
    }
    @PostMapping("/registration")
    private String Reg(modelUser user, Model model)
    {
        modelUser user_from_db = userRepository.findByUsername(user.getUsername());
        if (user_from_db != null)
        {
            model.addAttribute("message", "Пользователь с таким логином уже существует");
            return "regis";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(roleEnum.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
