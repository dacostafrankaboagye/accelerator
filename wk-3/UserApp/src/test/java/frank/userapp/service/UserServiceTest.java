package frank.userapp.service;

import frank.userapp.model.User;
import frank.userapp.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @Before
    public void setUp() {
        // MockitoAnnotations.initMocks(this);   if not using @SpringBootTest

        // Create a test user
        testUser = new User(1L, "Kendrick Lamar", "kendrick.lamar@gmail.com");
    }

    @After
    public void tearDown() {
        testUser = null;
    }

    @Test
    public void createUser() {
        when(userRepository.createUser(any(User.class))).thenReturn(testUser);

        User createdUser = userService.createUser(testUser);

        assertNotNull(createdUser);
        assertEquals("Kendrick Lamar", createdUser.getName());
        assertEquals("kendrick.lamar@gmail.com", createdUser.getEmail());

        verify(userRepository, times(1)).createUser(any(User.class));
    }

    @Test
    public void getUserById() {
        when(userRepository.getUserById(testUser.getId())).thenReturn(testUser);

        User fetchedUser = userService.getUserById(1L);

        assertNotNull(fetchedUser);
        assertEquals("Kendrick Lamar", fetchedUser.getName());

        verify(userRepository, times(1)).getUserById(1L);
    }

    @Test
    public void updateUser() {

    }

    @Test
    public void deleteUser() {

    }

    @Test
    public void getAllUsers() {

    }
}
