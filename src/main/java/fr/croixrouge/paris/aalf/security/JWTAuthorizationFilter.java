package fr.croixrouge.paris.aalf.security;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
  private JwtTokenService tokenService;

  public JWTAuthorizationFilter(
    AuthenticationManager authManager,
    ApplicationContext context
  ) {
    super(authManager);
    this.tokenService = context.getBean(JwtTokenService.class);
  }

  @Override
  protected void doFilterInternal(
    HttpServletRequest req,
    HttpServletResponse res,
    FilterChain chain
  )
    throws IOException, ServletException {
    String header = req.getHeader(HttpHeaders.AUTHORIZATION);

    if (header == null || !header.startsWith("Bearer ")) {
      chain.doFilter(req, res);
      return;
    }

    UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

    SecurityContextHolder.getContext().setAuthentication(authentication);
    chain.doFilter(req, res);
  }

  private UsernamePasswordAuthenticationToken getAuthentication(
    HttpServletRequest request
  ) {
    String token = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (token != null) {
      String username = tokenService.getUsername(token);
      if (username != null) {
        return new UsernamePasswordAuthenticationToken(
          username,
          null,
          new ArrayList<>()
        );
      }
      return null;
    }
    return null;
  }
}
