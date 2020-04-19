package fr.croixrouge.paris.aalf.classlevel;

import static lombok.AccessLevel.PRIVATE;

import fr.croixrouge.paris.aalf.course.Course;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "class_level")
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
