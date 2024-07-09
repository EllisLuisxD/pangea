package com.certus.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.certus.spring.models.Product;
import com.certus.spring.models.CheckOut;
import com.certus.spring.models.NumTarjeta;
import com.certus.spring.service.ICheckOutService;
import com.certus.spring.service.ProductService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/pangea")
public class CartController {
	
	@Autowired
	private ICheckOutService checkOutService;

    @Autowired
    private ProductService productService;

    @GetMapping("/cart")
    public String viewCart(Model model, HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        // Calcula el total del carrito
        double total = cart.stream().mapToDouble(Product::getPrice).sum();

        model.addAttribute("cart", cart);
        model.addAttribute("total", total);

        System.out.println("Carrito actual: " + cart);
        return "cart";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("productId") Long productId, HttpSession session) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        // Añadir el producto al carrito
        Product product = productService.findById(productId);
        cart.add(product);
        session.setAttribute("cart", cart);

        System.out.println("Producto añadido al carrito: " + product);
        System.out.println("Carrito después de añadir: " + cart);

        return "redirect:/pangea/cart";
    }

    @GetMapping("/checkout")
    public String showCheckoutPage(HttpSession session, Model model) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        double total = cart.stream().mapToDouble(Product::getPrice).sum();

        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        model.addAttribute("numTarjeta", new NumTarjeta()); // Añadir el objeto numTarjeta al modelo

        System.out.println("Carrito en checkout: " + cart);

        return "checkout";
    }

    @PostMapping("/checkout")
    public String checkout(HttpSession session, Model model) {
        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        double total = cart.stream().mapToDouble(Product::getPrice).sum();

        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        model.addAttribute("numTarjeta", new NumTarjeta()); // Añadir el objeto numTarjeta al modelo

        System.out.println("Carrito en checkout (POST): " + cart);

        return "checkout";
    }

	@PostMapping("/tarjeta")
	public String registroTarjeta(CheckOut numTarjeta, Model model) {
		
		CheckOut newTarjeta = new CheckOut();
		
		model.addAttribute("numTarjeta",newTarjeta);
		
		return checkOutService.obtenerTarjeta(numTarjeta);
	}	
}