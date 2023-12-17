package com.example.springmodels.controllers;
import com.example.springmodels.models.modelUser;
import com.example.springmodels.models.roleEnum;
import com.example.springmodels.models.*;
import com.example.springmodels.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class adminController {
    @Autowired
    private com.example.springmodels.repos.userRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/users")
    public String userView(Model model)
    {
        model.addAttribute("user_list", userRepository.findAll());
        return "index-users";
    }
    @GetMapping("/{id}")
    public String detailView(@PathVariable Long id, Model model)
    {
        model.addAttribute("user_object",userRepository.findById(id).orElseThrow());
        return "info";
    }
    @GetMapping("/{id}/update")
    public String updView(@PathVariable Long id, Model model)
    {
        model.addAttribute("user_object",userRepository.findById(id).orElseThrow());
        model.addAttribute("roles", roleEnum.values());
        return "update";
    }


    @PostMapping("/{id}/update")
    public String update_user(@RequestParam String username,
                              @RequestParam(name="roles[]", required = false) String[] roles,
                              @PathVariable Long id)
    {
        modelUser user = userRepository.findById(id).orElseThrow();
        user.setUsername(username);

        user.getRoles().clear();
        if(roles != null)
        {
            for(String role: roles)
            {
                user.getRoles().add(roleEnum.valueOf(role));
            }
        }



        userRepository.save(user);
        return "redirect:/admin/{id}";
    }
}
