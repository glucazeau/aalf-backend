package fr.croixrouge.paris.aalf.role;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name = "label")
  String label;

  @Column(name = "role")
  String value;
}
