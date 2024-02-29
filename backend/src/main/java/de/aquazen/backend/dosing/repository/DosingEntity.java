package de.aquazen.backend.dosing.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dosing_systems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DosingEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}
