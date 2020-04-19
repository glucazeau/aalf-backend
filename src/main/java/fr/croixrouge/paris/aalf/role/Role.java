package fr.croixrouge.paris.aalf.role;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "label")
  private String label;

  @Column(name = "role")
  private String value;
}
