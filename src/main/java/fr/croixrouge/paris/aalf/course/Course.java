package fr.croixrouge.paris.aalf.course;

import static lombok.AccessLevel.PRIVATE;

import fr.croixrouge.paris.aalf.classlevel.ClassLevel;
import fr.croixrouge.paris.aalf.classroom.ClassRoom;
import fr.croixrouge.paris.aalf.organization_branch.OrganizationBranch;
import fr.croixrouge.paris.aalf.semester.Semester;
import java.sql.Time;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "course")
@Data
@FieldDefaults(level = PRIVATE)
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  Integer dayOfWeek;

  @Column
  Time startTime;

  @Column
  Time endTime;

  @Column(name = "alternate_startdate")
  Date alternateStartDate;

  @Column(name = "alternate_enddate")
  Date alternateEndDate;

  @ManyToOne
  @JoinColumn(name = "fk_class_level")
  ClassLevel classLevel;

  @ManyToOne
  @JoinColumn(name = "fk_semester")
  Semester semester;

  @ManyToOne
  @JoinColumn(name = "fk_class_room")
  ClassRoom classRoom;

  @ManyToOne
  @JoinColumn(name = "fk_organization_branch")
  OrganizationBranch organizationBranch;
}
