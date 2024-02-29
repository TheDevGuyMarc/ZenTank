package de.aquazen.backend.ato.repository;

import de.aquazen.backend.ato.domain.Ato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ato_systems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public AtoEntity(Ato model) {
  }
}
