package de.aquazen.backend.misting.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "misting_systems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MistingEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}
