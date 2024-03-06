package de.aquazen.backend.errors.repository;

import de.aquazen.backend.errors.domain.Error;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "errors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String message;

  @Column
  private Date time;

  @Column
  private int count;

  public ErrorEntity(Error entity) {
    this.id = entity.getId();
    this.message = entity.getMessage();
    this.time = entity.getTime();
    this.count = entity.getCount();
  }
}
