package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String id) {
        for(Product product : productData) {
            if(product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public Product edit(Product product) {
        for(int i=0; i<productData.size(); i++) {
            Product currentProduct = productData.get(i);
            if(currentProduct.getProductId().equals(product.getProductId())) {
                productData.set(i, product);
                return product;
            }
        }
        return null;
    }

    public Product delete(String id) {
        Product product = productData.stream()
                .filter(p -> p.getProductId().equals(id))
                .findFirst()
                .orElse(null);
        productData.remove(product);
        return product;
    }
}
