package de.aquazen.backend.analoginput.repository;

import de.aquazen.backend.analoginput.domain.AnalogInput;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.drivers.repository.DriverEntity;
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

  @Column
  private String name;

  @Column
  private Pin pin;

  @Column
  private boolean state;

  @ManyToOne
  @JoinColumn(name = "drivers_id", referencedColumnName = "id")
  private DriverEntity driver;

  public AnalogInputEntity(AnalogInput entity) {
      this.id = entity.getId();
      this.name = entity.getName();
      this.pin = entity.getPin();
      this.state = entity.isState();
      this.driver = new DriverEntity(entity.getDriver());
  }
}
