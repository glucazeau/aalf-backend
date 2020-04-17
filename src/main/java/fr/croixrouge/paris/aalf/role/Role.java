package fr.croixrouge.paris.aalf.role;

import fr.croixrouge.paris.aalf.user.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
public class Role {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "role")
    private String value;

    @OneToMany
    private Set<UserEntity> users;
}