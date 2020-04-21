package fr.croixrouge.paris.aalf.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.croixrouge.paris.aalf.role.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "teacher")
@Data
public class UserEntity implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name = "email", insertable = false, updatable = false)
  String username;

  @Column(name = "email")
  String emailAddress;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  String password;

  @Column(name = "last_name")
  String lastName;

  @Column(name = "first_name")
  String firstName;

  @Column(name = "cellphone_number")
  String phoneNumber;

  @Column(name = "enabled")
  boolean enabled;

  @Column(name = "locked")
  boolean locked;

  @Column(name = "expired")
  boolean expired;

  @Column(name = "expires_at")
  Date expiresAt;

  @Column(name = "credentials_expired")
  boolean credentialsExpired;

  @Column(name = "credentials_expire_at")
  Date credentialsExpiresAt;

  @Column(name = "confirmation_token")
  String confirmationToken;

  @Column(name = "password_requested_at")
  Date passwordRequestAt;

  @Column(name = "registration_date")
  Date registrationDate;

  @ManyToOne
  @JoinColumn(name = "fk_role_id")
  Role role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(role.getValue()));
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return !expired;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return !locked;
  }

  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return !credentialsExpired;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }
}
