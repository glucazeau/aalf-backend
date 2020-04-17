package fr.croixrouge.paris.aalf.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.croixrouge.paris.aalf.user.UserEntity;
import lombok.extern.java.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static fr.croixrouge.paris.aalf.security.JwtValues.HEADER_PREFIX;

@Log
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private JwtTokenService tokenService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, ApplicationContext context) {
        this.authenticationManager = authenticationManager;
        this.tokenService = context.getBean(JwtTokenService.class);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            UserEntity creds = new ObjectMapper()
                    .readValue(req.getInputStream(), UserEntity.class);

            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    creds.getUsername(),
                    creds.getPassword(),
                    new ArrayList<>());

            return authenticationManager.authenticate(authToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) {
        String username = ((UserEntity)auth.getPrincipal()).getUsername();
        String token = tokenService.newToken(username);
        res.addHeader(HttpHeaders.AUTHORIZATION, HEADER_PREFIX + token);
    }
}