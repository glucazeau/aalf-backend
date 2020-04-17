package fr.croixrouge.paris.aalf.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

import static fr.croixrouge.paris.aalf.security.JwtValues.HEADER_PREFIX;
import static io.jsonwebtoken.SignatureAlgorithm.HS256;
import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class JwtTokenService {
    SecretKey privateKey;

    @Autowired
    public JwtTokenService(@Value("${jwt.key.private:secret}") String privateKey) {
        this.privateKey = Keys.hmacShaKeyFor(privateKey.getBytes(StandardCharsets.UTF_8));
    }

    public String newToken(String username) {
        final Claims claims = Jwts
                .claims()
                .setIssuer("AALF")
                .setSubject(username);

        return Jwts
                .builder()
                .setClaims(claims)
                .signWith(privateKey, HS256)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(privateKey).build().parseClaimsJws(token.replace(HEADER_PREFIX, "")).getBody().getSubject();
    }
}
