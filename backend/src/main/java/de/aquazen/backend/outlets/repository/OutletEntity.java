package de.aquazen.backend.outlets.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "outlets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutletEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}
