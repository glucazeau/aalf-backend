package fr.croixrouge.paris.aalf.role;

import fr.croixrouge.paris.aalf.user.UserEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String name;

    @OneToMany
    private Set<UserEntity> users;
}