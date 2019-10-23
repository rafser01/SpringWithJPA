/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.bitsofts.springwithhibernate.controller;

import io.bitsofts.springwithhibernate.repository.ProductRepository;
import java.util.Collection;
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
public class ReportController {
    @Autowired
    private ProductRepository pr;
    
    @RequestMapping(method = RequestMethod.GET, value = "/exportSales")
    public String generateSalesReport(HttpServletRequest request, Model model){
        model.addAttribute("products", (Collection<?>) pr.findAll());
        return "exportProducts";
    }
}
