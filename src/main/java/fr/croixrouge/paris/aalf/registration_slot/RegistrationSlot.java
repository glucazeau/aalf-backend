package fr.croixrouge.paris.aalf.registration_slot;

import fr.croixrouge.paris.aalf.semester.Semester;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

import static lombok.AccessLevel.PRIVATE;

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
