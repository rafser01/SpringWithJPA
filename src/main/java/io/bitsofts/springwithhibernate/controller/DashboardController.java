/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.bitsofts.springwithhibernate.controller;

import io.bitsofts.springwithhibernate.model.Item;
import io.bitsofts.springwithhibernate.model.Product;
import io.bitsofts.springwithhibernate.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {
    
    @Autowired
    private ProductRepository pr;
    @RequestMapping(value = "/home")
    public String home(HttpServletRequest request, Model model){
        List<Product> products = (List<Product>) pr.findAll();
        List<List<Product>> productRowList = new ArrayList<>();
        List<Product> columnsProducts = new ArrayList<>();
        for(int i=0; i<products.size(); i++){
            if(i%4 == 0){
                productRowList.add(columnsProducts);
                columnsProducts = new ArrayList<>();
            } else if (products.size() % 4 != 0 && products.size()-1 == 1) {
                 productRowList.add(columnsProducts);
            }
            columnsProducts.add(products.get(i));
        }
        System.out.println("------------------rows "+productRowList.size());
        model.addAttribute("items", productRowList);
        return "homePage";
    }
    
    @RequestMapping(value = "/cartItems")
    public String cartItems(HttpSession session){
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        if(cart == null) {
//            session.setAttribute("cart", null);
            return "cartPage";
        } else {
            session.setAttribute("cart", cart);
            return "cartPage";
        }
    }
    
    @RequestMapping(value = "/addItem/{id}")
    public String addCartItem(@PathVariable Integer id, HttpServletRequest request, HttpSession session){
        Product p = pr.findOne(id);
        Item i = new Item();
        i.setProduct(p);
        i.setQuantity(1);
        if(session.getAttribute("cart") == null){
            List<Item> cart = new ArrayList<>();
            cart.add(i);
            Double total = i.getProduct().getPrice()*i.getQuantity();
            session.setAttribute("cart", cart);
            session.setAttribute("total", total);
        } else {
            List<Item> cart = (List<Item>) session.getAttribute("cart");
            boolean existing = false;
            for(int n=0;n<cart.size();n++) {
                if(cart.get(n).getProduct().getId()== id) {
                    existing = true;
                    int previousQty = cart.get(n).getQuantity();
                    cart.get(n).setQuantity(previousQty+i.getQuantity());
                }
            }
            if(existing == false) {
                cart.add(i);
            }
            
            Double total = 0.0;
            for(int n=0;n<cart.size();n++) {
                total +=cart.get(n).getProduct().getPrice()*cart.get(n).getQuantity();
            }
            session.setAttribute("total", total);
            session.setAttribute("cart", cart);
        }
        
//        if(request.getRequestURI().indexOf("dashboard") > -1){
//            System.out.println("Url ------------ "+request.getRequestURI()+"--"+request.getRequestURL());
//            return "redirect:/dashboard/home";
//        } else if(request.getRequestURI().indexOf("otherPage") > -1) {
//            return "redirect:/otherPage/home";
//        }
        
        return "redirect:/dashboard/home";
    }
    @RequestMapping(value = "/confirmPayment")
    public String confirmPayment(HttpSession session){
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        for(int i=0; i<cart.size(); i++) {
            Item item = cart.get(i);
            // 1. product table update
            // 2. Store/save in memo table
            // 3. Store payment information into payment table

        }
        return "";
    }
}
