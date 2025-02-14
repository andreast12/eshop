package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private String productId;
    private String productName;
    private int productQuantity;
    private static int lastId = 0;

    private String generateNextId() {
        return String.valueOf(++lastId);
    }

    public Product() {
        productId = generateNextId();
    }
}