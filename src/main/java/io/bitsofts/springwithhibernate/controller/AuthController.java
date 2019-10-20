/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.bitsofts.springwithhibernate.controller;

import io.bitsofts.springwithhibernate.model.User;
import io.bitsofts.springwithhibernate.repository.UserRepository;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrator
 */
@Controller
public class AuthController {
    
    @Autowired
    private UserRepository repository;
    
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String login(){
        return "loginPage";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginGet(){
        return "loginPage";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/signup")
    public String signupGet(){
        return "signupPage";
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/loginSubmit")
     public String loginSubmitPost(HttpServletRequest request, Model model) {
         String id = request.getParameter("username");
         String password = request.getParameter("password");
         System.out.println("----------------- "+id);
         if(!id.isEmpty() && !password.isEmpty()) {
             User u = repository.findByIdAndPassword(Integer.parseInt(id), password);
             System.out.println("----- "+u.getName());
             if(!u.equals(null)) {
                 return "homePage";
             } else {
                 model.addAttribute("error", "User Name or Password does not  match!");
                 return "loginPage";
             }
         }
         model.addAttribute("error", "Input fileds");
         return "loginPage";
     }
     
     @RequestMapping(method = RequestMethod.POST, value = "/signupSubmit")
     public String signupSubmitPost(HttpServletRequest request, Model model) {
         String name = request.getParameter("name");
         String password = request.getParameter("password");
         String email = request.getParameter("email");
         User u = new User();
         u.setEmail(email);
         u.setName(name);
         u.setPassword(password);
         try {
             repository.save(u);
             return "loginPage";
         } catch (Exception e) {
             System.out.println("Error "+e.getMessage());
             model.addAttribute("error", e.getMessage());
             return "signupPage";
         }
         
     }
    
}
