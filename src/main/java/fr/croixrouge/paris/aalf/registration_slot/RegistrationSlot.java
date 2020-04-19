package fr.croixrouge.paris.aalf.registration_slot;

import static lombok.AccessLevel.PRIVATE;

import fr.croixrouge.paris.aalf.semester.Semester;
import java.sql.Time;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "registration_slots")
@Data
@FieldDefaults(level = PRIVATE)
public class RegistrationSlot {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "slot_date")
  Date date;

  @Column(name = "start_time")
  Time startTime;

  @Column(name = "end_time")
  Time endTime;

  @ManyToOne
  @JoinColumn(name = "fk_semester")
  Semester semester;
}
