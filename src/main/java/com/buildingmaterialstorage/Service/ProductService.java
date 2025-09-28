package com.buildingmaterialstorage.Service;

import com.buildingmaterialstorage.Model.Product;
import com.buildingmaterialstorage.Repository.ProductRepository;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor(force = true)
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        if (productRepository == null) {
            throw new RuntimeException("Ошибка: продуктов нет.");
        } else {
            return productRepository.save(product);
        }
    }

    public Optional<Product> getProductByProductId(Long productId) {
        return productRepository.findById(productId);
    }

    public Optional<Product> updateProductData(Long productId, Product updatedProduct) {
        return productRepository.findById(productId).map(existingProduct -> {
            existingProduct.setProductId(updatedProduct.getProductId());
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setProductPrice(updatedProduct.getProductPrice());
            return productRepository.save(existingProduct);
        });
    }

    public void removeProductByProductId(Long productId) {
        if (productRepository != null && productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
        } else {
            throw new RuntimeException("Ошибка: Продукта с таким ID не существует.");
        }
    }
}
