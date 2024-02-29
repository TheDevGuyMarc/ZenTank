package de.aquazen.backend.analoginput.repository;

import de.aquazen.backend.analoginput.domain.AnalogInput;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "analog_inputs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnalogInputEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  public AnalogInputEntity(AnalogInput model) {

  }
}
