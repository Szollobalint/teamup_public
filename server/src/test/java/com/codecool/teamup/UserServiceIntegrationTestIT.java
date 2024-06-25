package com.codecool.teamup;

import com.codecool.teamup.model.JwtResponse;
import com.codecool.teamup.model.request.LoginRequest;
import com.codecool.teamup.model.user.MyUser;
import com.codecool.teamup.security.jwt.JwtUtils;
import com.codecool.teamup.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=${DATABASE_URL}",
        "spring.datasource.username=${DATABASE_USERNAME}",
        "spring.datasource.password=${DATABASE_PASSWORD}"
})
public class UserServiceIntegrationTestIT {

    @Autowired
    private UserService userService;

    @MockBean
    private JwtUtils jwtUtils;

    @MockBean
    private AuthenticationManager authenticationManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoginUser() {
        LoginRequest loginRequest = new LoginRequest("bájint", "asd");
        Authentication authentication = mock(Authentication.class);

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(jwtUtils.generateJwtToken(authentication)).thenReturn("test-jwt-token");

        MyUser myUser = mock(MyUser.class);
        when(authentication.getPrincipal()).thenReturn(myUser);
        when(myUser.getUsername()).thenReturn("bájint");
        when(myUser.getAuthorities()).thenReturn(List.of(new SimpleGrantedAuthority("ROLE_USER")));
        when(myUser.getId()).thenReturn(1L);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        JwtResponse jwtResponse = userService.loginUser(loginRequest);

        assertNotNull(jwtResponse);
        assertEquals("test-jwt-token", jwtResponse.jwt());
        assertEquals("bájint", jwtResponse.name());
        assertTrue(jwtResponse.roles().contains("ROLE_USER"));
        assertEquals(1L, jwtResponse.id());
    }
}
