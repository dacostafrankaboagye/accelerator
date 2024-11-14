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

import java.util.List;

import static org.junit.Assert.*;
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
        User updatedUser = new User(1L, "Kendrick Lamar Updated", "kendrick.updated@gmail.com");
        when(userRepository.updateUser(eq(1L), any(User.class))).thenReturn(updatedUser);

        User returnedUser = userService.updateUser(1L, updatedUser);

        assertNotNull(returnedUser);
        assertEquals("Kendrick Lamar Updated", returnedUser.getName());
        assertEquals("kendrick.updated@gmail.com", returnedUser.getEmail());

        verify(userRepository, times(1)).updateUser(eq(1L), any(User.class));

    }

    @Test
    public void deleteUser() {

        doNothing().when(userRepository).deleteUser(1L);

        userService.deleteUser(1L);

        verify(userRepository, times(1)).deleteUser(1L);
    }

    @Test
    public void getAllUsers() {

        when(userRepository.getAllUsers()).thenReturn(List.of(testUser));

        var users = userService.getAllUsers();

        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertEquals(1, users.size());
        assertEquals("Kendrick Lamar", users.getFirst().getName());

        verify(userRepository, times(1)).getAllUsers();

    }
}
