package id.ac.ui.cs.advprog.eshop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentTest {
    private Order order;
    private Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setProductId("5fcaedb7-ce8a-4236-9943-fc8bf36d3e07");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(1);
        products.add(product);

        this.order = new Order("9ebb7f22-4ea8-42de-a395-1e7501a34ce2", products, 1710000000L, "Test User");

        this.paymentData = new HashMap<>();
        this.paymentData.put("voucherCode", "ESHOP12345678ABC");
    }

    @Test
    void testCreatePayment() {
        Payment payment = new Payment("test-payment-id", order, "VOUCHER", paymentData);

        assertEquals("test-payment-id", payment.getId());
        assertEquals(order, payment.getOrder());
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals(paymentData, payment.getPaymentData());
        assertEquals("PENDING", payment.getStatus()); // Default status
    }

    @Test
    void testSetStatus() {
        Payment payment = new Payment("test-payment-id", order, "VOUCHER", paymentData);
        payment.setStatus("SUCCESS");

        assertEquals("SUCCESS", payment.getStatus());
    }
}