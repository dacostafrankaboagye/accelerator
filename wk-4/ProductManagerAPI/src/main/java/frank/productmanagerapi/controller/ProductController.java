package frank.productmanagerapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final List<Map<String, String>> products = List.of(
            Map.of("id", "1", "name", "Laptop", "price", "1500"),
            Map.of("id", "2", "name", "Phone", "price", "800"),
            Map.of("id", "3", "name", "Headphones", "price", "200"),
            Map.of("id", "4", "name", "Smart Watch", "price", "300"),
            Map.of("id", "5", "name", "Gaming Console", "price", "500"),
            Map.of("id", "6", "name", "Tablet", "price", "400"),
            Map.of("id", "7", "name", "4K TV", "price", "1200"),
            Map.of("id", "8", "name", "Bluetooth Speaker", "price", "150"),
            Map.of("id", "9", "name", "Camera", "price", "1000"),
            Map.of("id", "10", "name", "External Hard Drive", "price", "100")
    );

    @GetMapping
    public List<Map<String, String>> getAllProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Map<String, String> getProductById(@PathVariable String id) {
        return products.stream()
                .filter(product -> product.get("id").equals(id))
                .findFirst().orElse(null);
    }

}
