package it.ioprogrammatore.astronamical.utils;

import it.ioprogrammatore.astronamical.exceptions.FutureDateException;
import it.ioprogrammatore.astronamical.models.records.Observation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AstronomicalObservationUtils {
    public static final BigDecimal AU_IN_KM = new BigDecimal("149597871");

    public static BigDecimal calculateDistanceInAU(BigDecimal distanceKm) {
        return distanceKm.divide(AU_IN_KM, MathContext.DECIMAL64);
    }

    public static Observation recordObservation(String dateStr, String celestialBody, BigDecimal distanceKm) throws FutureDateException {
        try {
            LocalDate date = LocalDate.parse(dateStr);
            if (date.isAfter(LocalDate.now())) {
                throw new FutureDateException();
            }
            return new Observation(date, celestialBody, distanceKm);
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format.");
            throw e;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }
}
