package fr.croixrouge.paris.aalf.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.croixrouge.paris.aalf.user.UserEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.java.Log;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

@Log
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    public JWTAuthenticationFilter(final AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(final HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
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
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {
        String username = ((UserEntity)auth.getPrincipal()).getUsername();

        final Claims claims = Jwts
                .claims()
                .setIssuer("AALF")
                .setSubject(username);

        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String token =  Jwts
                .builder()
                .setClaims(claims)
                .signWith(key, HS256)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        res.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
    }
}