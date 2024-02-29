package de.aquazen.backend.temperature.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "temperature_probes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}
