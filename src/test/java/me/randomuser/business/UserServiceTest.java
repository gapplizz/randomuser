package me.randomuser.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import me.randomuser.business.user.User;
import me.randomuser.business.user.UserService;
import me.randomuser.out.user.UserInterface;
import me.randomuser.out.user.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock UserRepository userRepository;
    UserService userService;

    @BeforeEach
    void setup(){
        this.userService = new UserService(userRepository);
    }

    @Test
    void RandomUser_WhenSeedIsNull_ShouldRandomUser(){
        when(userRepository.get(anyInt())).thenReturn(mockUserInterfaceData());

        User actualUser = userService.randomUser(null);

        assertNotNull(actualUser.getName());
    }

    @Test
    void RandomUser_WhenSeedNotNull_ShouldRandomUser(){
        when(userRepository.get(anyInt())).thenReturn(mockUserInterfaceData());

        User actualUser = userService.randomUser("bar");

        assertNotNull(actualUser.getName());
    }

    @Test
    void RandomUser_WhenSeedIsSame_ShouldRandomSameUser(){
        when(userRepository.get(819)).thenReturn(mockUserInterfaceData());

        User firstTimes = userService.randomUser("bar");
        User secondTimes = userService.randomUser("bar");
        
        assertEquals(firstTimes.getName(), secondTimes.getName());
    }

    private UserInterface mockUserInterfaceData(){
        UserInterface user = new UserInterface();
        user.setName("foo");

        return user;
    }
}
