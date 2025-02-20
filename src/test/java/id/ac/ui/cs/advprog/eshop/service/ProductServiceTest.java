package id.ac.ui.cs.advprog.eshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

import java.util.List;
import java.util.Iterator;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository; // Mocking ProductRepository

    @BeforeEach
    public void setUp() {}

    @Test
    void testCreate() {
        Product product = new Product();
        when(productRepository.create(product)).thenReturn(product); // Mock behavior

        Product response = productService.create(product);

        assertEquals(product, response);
        verify(productRepository).create(product); // Verify method was called
    }

    @Test
    void testFindAll() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);

        Iterator<Product> productIterator = Arrays.asList(product1, product2).iterator();
        when(productRepository.findAll()).thenReturn(productIterator); // Mock repository response

        List<Product> products = productService.findAll();

        assertEquals(2, products.size());
        verify(productRepository).findAll();
    }

    @Test
    void testFindById() {
        Product product = new Product();
        product.setProductId("123");
        when(productRepository.findById("123")).thenReturn(product);

        Product response = productService.findById("123");

        assertEquals(product, response);
        verify(productRepository).findById("123");
    }

    @Test
    void testEdit() {
        Product product = new Product();
        product.setProductId("123");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        when(productRepository.edit(product)).thenReturn(product);

        Product response = productService.edit(product);

        assertEquals(product, response);
        verify(productRepository).edit(product);
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("123");
        when(productRepository.delete("123")).thenReturn(product);

        Product response = productService.delete("123");

        assertEquals(product, response);
        verify(productRepository).delete("123");
    }
}
