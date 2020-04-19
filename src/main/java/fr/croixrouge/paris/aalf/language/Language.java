package fr.croixrouge.paris.aalf.language;

import javax.persistence.*;
import lombok.Data;

@Entity(name = "language")
@Data
public class Language {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name")
  private String name;
}
