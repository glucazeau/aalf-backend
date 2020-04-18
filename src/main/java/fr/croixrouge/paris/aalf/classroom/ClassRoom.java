package fr.croixrouge.paris.aalf.classroom;

import fr.croixrouge.paris.aalf.Course;
import fr.croixrouge.paris.aalf.organization_branch.OrganizationBranch;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "classroom")
@Data
@FieldDefaults(level = PRIVATE)
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String name;

    @Column
    String comments;

    @Column
    String address;

    @ManyToOne
    @JoinColumn(name="fk_organization_branch")
    OrganizationBranch organizationBranch;

    @OneToMany(mappedBy = "classRoom")
    Set<Course> courses;
}
