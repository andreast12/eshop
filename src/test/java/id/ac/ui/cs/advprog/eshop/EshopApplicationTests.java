package id.ac.ui.cs.advprog.eshop;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EshopApplicationTests {
    @Test
    void contextLoads() {
        // Ensures the Spring Boot application context loads
    }

    @Test
    void mainMethodRuns() {
        // Ensures that the main method runs without throwing exceptions
        assertDoesNotThrow(() -> EshopApplication.main(new String[]{}));
    }
}
