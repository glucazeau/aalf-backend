package fr.croixrouge.paris.aalf.organization_branch;

import fr.croixrouge.paris.aalf.classroom.ClassRoom;
import fr.croixrouge.paris.aalf.semester.Semester;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "organization_branch")
@Data
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
public class OrganizationBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    String name;

    @Column
    String address;

    @Column(name = "president_name")
    String presidentName;

    @Column(name = "phone_number")
    String phoneNumber;

    @Column(name = "fax_number")
    String faxNumber;

    @Column(name = "email_address")
    String emailAddress;

    @OneToMany(mappedBy = "organizationBranch")
    Set<ClassRoom> classRooms;

    @OneToMany(mappedBy = "organizationBranch")
    Set<Semester> semesters;
}
