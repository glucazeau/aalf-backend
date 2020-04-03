package fr.croixrouge.paris.aalf.classlevel;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="class_level")
@Data
public class ClassLevel {
    @Id
    private int id;

    private String label;

    private String htmlColorCode;

    private Integer position;
}
