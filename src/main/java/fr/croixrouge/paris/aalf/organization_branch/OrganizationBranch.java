package fr.croixrouge.paris.aalf.organization_branch;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

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
}
