package fr.croixrouge.paris.aalf.classlevel;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="class_level")
@Data
public class ClassLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String label;

    private String htmlColorCode;

    private Integer position;
}
