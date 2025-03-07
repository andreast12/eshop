package id.ac.ui.cs.advprog.eshop.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;

class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    List<Payment> payments;
    Order testOrder;

    @BeforeEach
    void setup() {
        paymentRepository = new PaymentRepository();

        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setProductId("5fcaedb7-ce8a-4236-9943-fc8bf36d3e07");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(1);
        products.add(product);

        testOrder = new Order("9ebb7f22-4ea8-42de-a395-1e7501a34ce2", products, 1710000000L, "Test User");

        payments = new ArrayList<>();

        Map<String, String> paymentData1 = new HashMap<>();
        paymentData1.put("voucherCode", "ESHOP12345678ABC");
        Payment payment1 = new Payment("payment1", testOrder, "VOUCHER", paymentData1);
        payments.add(payment1);

        Map<String, String> paymentData2 = new HashMap<>();
        paymentData2.put("address", "Test Address");
        paymentData2.put("deliveryFee", "10000");
        Payment payment2 = new Payment("payment2", testOrder, "COD", paymentData2);
        payments.add(payment2);
    }

    @Test
    void testSaveCreate() {
        Payment payment = payments.getFirst();
        Payment result = paymentRepository.save(payment);

        Payment findResult = paymentRepository.findById(payment.getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getStatus(), findResult.getStatus());
        assertEquals(payment.getOrder().getId(), findResult.getOrder().getId());
    }

    @Test
    void testSaveUpdate() {
        Payment payment = payments.getFirst();
        paymentRepository.save(payment);

        payment.setStatus("SUCCESS");
        Payment result = paymentRepository.save(payment);

        Payment findResult = paymentRepository.findById(payment.getId());
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals("SUCCESS", findResult.getStatus());
    }

    @Test
    void testFindByIdIfFound() {
        Payment payment = payments.getFirst();
        paymentRepository.save(payment);

        Payment findResult = paymentRepository.findById(payment.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getStatus(), findResult.getStatus());
    }

    @Test
    void testFindByIdIfNotFound() {
        Payment findResult = paymentRepository.findById("nonexistentId");
        assertNull(findResult);
    }

    @Test
    void testFindAll() {
        assertTrue(paymentRepository.findAll().isEmpty());

        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        List<Payment> allPayments = paymentRepository.findAll();
        assertEquals(2, allPayments.size());
    }
}