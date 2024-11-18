package frank.productmanagerapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final List<Map<String, String>> products = new ArrayList<>(
            List.of(
                    new HashMap<>(Map.of("id", "1", "name", "Laptop", "price", "1500")),
                    new HashMap<>(Map.of("id", "2", "name", "Phone", "price", "800")),
                    new HashMap<>(Map.of("id", "3", "name", "Headphones", "price", "200")),
                    new HashMap<>(Map.of("id", "4", "name", "Smart Watch", "price", "300")),
                    new HashMap<>(Map.of("id", "5", "name", "Gaming Console", "price", "500"))
            )
    );

    @GetMapping
    public List<Map<String, String>> getAllProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id) {
        return products.stream()
                .filter(product -> product.get("id").equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Map<String, String> product) {
        String id = UUID.randomUUID().toString();
        product.put("id", id);
        products.add(product);
        return ResponseEntity
                .status(CREATED)
                .body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody Map<String, String> updates) {
        for (Map<String, String> product : products) {
            if (product.get("id").equals(id)) {
                product.putAll(updates);
                return ResponseEntity.ok(product);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        boolean removed = products.removeIf(product -> product.get("id").equals(id));
        if (removed) {
            return ResponseEntity.ok("Product deleted");
        }
        return ResponseEntity.notFound().build();
    }


}
