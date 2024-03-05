package de.aquazen.backend.measurement.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MeasurementNotFoundException extends RuntimeException {
  public MeasurementNotFoundException(String message) {
    super(message);
  }

  public MeasurementNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public MeasurementNotFoundException(Throwable cause) {
    super(cause);
  }

  public MeasurementNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
