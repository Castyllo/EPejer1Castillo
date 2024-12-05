/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.EPejer1Castillo.controller;

import com.example.EPejer1Castillo.model.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author casti
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginUser", new LoginUser());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute LoginUser loginUser, Model model) {
        if ("admin".equals(loginUser.getUsername()) && "admin".equals(loginUser.getPassword())) {
            return "success";
        } else {
            model.addAttribute("error", "Credenciales inválidas. Por favor, inténtelo de nuevo.");
            return "login";
        }
    }
}
