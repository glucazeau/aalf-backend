package fr.croixrouge.paris.aalf.language;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "language")
@Data
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
}
