package com.buildingmaterialstorage.Controller;

import com.buildingmaterialstorage.Model.Product;
import com.buildingmaterialstorage.Repository.ProductRepository;
import com.buildingmaterialstorage.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewMainPage() {
        return "redirect:/main";
    }

    @PostMapping("/products/add-product")
    public String addProducts(Product product) {
        productService.addProduct(product);
        return "redirect:/main";
    }

    @PutMapping("/update-product-data")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @PathVariable Product product) {
        Optional<Product> updatedProduct = productService.updateProductData(productId, product);
        return updatedProduct.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/find-product-by-product-id")
    public String getProductById(Long productId) {
        productService.getProductByProductId(productId);
        return "redirect:/main";
    }

    @DeleteMapping("/products/remove-product")
    public String removeProductByProductId(Long productId) {
        productService.removeProductByProductId(productId);
        return "redirect:/main";
    }
}
