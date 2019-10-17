/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.bitsofts.springwithhibernate;

import io.bitsofts.springwithhibernate.repository.ProductRepository;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Administrator
 */
@Controller

public class Home {
    
    @Autowired
    private ProductRepository pr;
    @RequestMapping("/")
    public String home(HttpServletRequest request, Model m){
        System.out.println("Count --------------- "+pr.count());
        m.addAttribute("count", pr.count());
        return "index";
    }

    @RequestMapping("/hk")
    public String hk(HttpServletRequest request, Model m){
        System.out.println("Count --------------- "+pr.count());
        m.addAttribute("count", pr.count());
        return "index";
    }
    
}
