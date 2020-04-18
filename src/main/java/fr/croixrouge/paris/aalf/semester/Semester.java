package fr.croixrouge.paris.aalf.semester;

import fr.croixrouge.paris.aalf.organization_branch.OrganizationBranch;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "semester")
@Data
@FieldDefaults(level = PRIVATE)
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "start_date")
    Date startDate;

    @Column(name = "end_date")
    Date endDate;

    @ManyToOne
    @JoinColumn(name = "fk_organization_branch")
    OrganizationBranch organizationBranch;
}
