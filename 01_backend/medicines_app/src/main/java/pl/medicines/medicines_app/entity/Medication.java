package pl.medicines.medicines_app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "medication_name")
    private String medicationName;

    @Column(name = "medication_destination")
    private String medicationDestination;
}
