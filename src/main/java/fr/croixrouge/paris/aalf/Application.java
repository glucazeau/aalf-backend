package fr.croixrouge.paris.aalf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;

@SpringBootApplication
public class Application {
    /*
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    */

    @Bean
    public MessageDigestPasswordEncoder md5PasswordEncoder() {;
        MessageDigestPasswordEncoder encoder = new MessageDigestPasswordEncoder("SHA-512");
        encoder.setIterations(5000);
        return encoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
