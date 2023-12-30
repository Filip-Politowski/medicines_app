package pl.medicines.medicines_app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "medications_taken")
public class MedicationsTaken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "medication_id")
    private Long medicationId;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "date_of_intake")
    private String dateOfIntake;

}
