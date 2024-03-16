package com.ohgiraffers.homework.product.controller;

import com.ohgiraffers.homework.product.model.dto.ProductDTO;
import com.ohgiraffers.homework.product.model.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;
    private final MessageSource messageSource;

    public ProductController(ProductService productService, MessageSource messageSource) {
        this.productService = productService;
        this.messageSource = messageSource;
    }


    @GetMapping("/list")
    public String findProductList(Model model) {

        List<ProductDTO> productList = productService.findAllProduct();

        model.addAttribute("productList", productList);

        return "product/list";
    }

    @GetMapping("/regist")
    public void registPage() {}

    @PostMapping("/regist")
    public String registProduct(@ModelAttribute ProductDTO product, RedirectAttributes rttr, Locale locale) {

        logger.trace("product : {}", product);
        logger.debug("product : {}", product);
        logger.info("product : {}", product);
        logger.warn("product : {}", product);
        logger.error("product : {}", product);

        productService.registProduct(product);

        rttr.addFlashAttribute("successMessage", messageSource.getMessage("registProduct", null, locale));


        return "redirect:/product/list";
    }

}
