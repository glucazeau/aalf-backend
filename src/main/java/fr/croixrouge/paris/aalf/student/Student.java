package fr.croixrouge.paris.aalf.student;

import static lombok.AccessLevel.PRIVATE;

import fr.croixrouge.paris.aalf.organization_branch.OrganizationBranch;
import fr.croixrouge.paris.aalf.user.UserEntity;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "student")
@Data
@FieldDefaults(level = PRIVATE)
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name = "registration_date")
  Date registrationDate;

  @Column(name = "lastname")
  String lastname;

  @Column(name = "firstname")
  String firstname;

  @Column(name = "birthdate")
  Date birthdate;

  @Column(name = "cellphone_number")
  String phoneNumber;

  @Column(name = "address")
  String address;

  @Column(name = "zipcode")
  String zipcode;

  @Column(name = "city")
  String city;

  @Column(name = "gender")
  String gender;

  @Column(name = "nationality")
  String nationality;

  @Column(name = "arrival_date")
  Date arrivalDate;

  @Column(name = "arrival_date")
  Boolean scholarized;

  @Column(name = "profession")
  String profession;

  @Column(name = "emergency_contact_lastname")
  String emergencyContactLastname;

  @Column(name = "emergency_contact_firstname")
  String emergencyContactFirstname;

  @Column(name = "emergency_contact_phone_number")
  String emergencyContactPhoneNumber;

  @Column(name = "emergency_contact_connection_type")
  String emergencyContactConnectionType;

  @Column(name = "nativeCountry")
  String nativeCountry;

  @ManyToOne
  @JoinColumn(name = "fk_updated_by_teacher")
  UserEntity updatedBy;

  @Column(name = "updatedAt")
  Date updatedAt;

  @ManyToOne
  @JoinColumn(name = "fk_welcomed_by_teacher")
  UserEntity welcomedBy;

  @ManyToOne
  @JoinColumn(name = "fk_organization_branch")
  OrganizationBranch organizationBranch;
}
