package de.aquazen.backend.ph.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pH_probes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}
