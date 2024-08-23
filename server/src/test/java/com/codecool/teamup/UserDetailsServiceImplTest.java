package com.codecool.teamup;

import com.codecool.teamup.model.user.MyUser;
import com.codecool.teamup.model.user.UserEntity;
import com.codecool.teamup.repository.UserRepository;
import com.codecool.teamup.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


public class UserDetailsServiceImplTest {

    private UserDetailsServiceImpl userDetailsService;

    private final UserRepository userRepository = Mockito.mock(UserRepository.class);

    @BeforeEach
    void setUp() {
        this.userDetailsService = Mockito.spy(new UserDetailsServiceImpl(userRepository));
    }

    @Test
    void loadUserByUsernameWhenUserExists() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername("test user");
        userEntity.setPassword("password");
        String authority = "ROLE_USER";
        doReturn(List.of(authority)).when(userDetailsService).getRoles(userEntity);
        when(userRepository.findByUsername(userEntity.getUsername())).thenReturn(Optional.of(userEntity));

        UserDetails expected = new MyUser(1L, "test user", "password", List.of(new SimpleGrantedAuthority(authority)));
        UserDetails actual = userDetailsService.loadUserByUsername(userEntity.getUsername());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void loadUserByUsernameWhenUserDoesNotExist() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername("test user");
        userEntity.setPassword("password");

        String authority = "ROLE_USER";

        doReturn(List.of(authority)).when(userDetailsService).getRoles(userEntity);
        when(userRepository.findByUsername(userEntity.getUsername())).thenReturn(Optional.empty());

        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername(userEntity.getUsername());
        });
    }
}
