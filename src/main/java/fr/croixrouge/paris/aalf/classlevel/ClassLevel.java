package fr.croixrouge.paris.aalf.classlevel;

import fr.croixrouge.paris.aalf.course.Course;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name="class_level")
@Data
@FieldDefaults(level = PRIVATE)
public class ClassLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String label;

    @Column
    String htmlColorCode;

    @Column
    Integer position;

    @OneToMany(mappedBy = "classLevel")
    Set<Course> courses;
}
