package frank.secureshop.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a SecureShopUser in the database.
 * This class is used to store user details such as username, password, and role.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SecureShopUser {

    /**
     * The unique ID of the user, automatically generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The username of the user.
     */
    private String username;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * The role of the user (e.g., ROLE_REGULAR, ROLE_STAFF, ROLE_ADMIN).
     */
    private String role;

}
