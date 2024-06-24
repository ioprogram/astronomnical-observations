package it.ioprogrammatore.astronamical;

import it.ioprogrammatore.astronamical.exceptions.FutureDateException;
import it.ioprogrammatore.astronamical.models.records.Observation;
import it.ioprogrammatore.astronamical.utils.AstronomicalObservationUtils;

import java.math.BigDecimal;

public class AstronomicalObservations {
    public static void main(String[] args) {
        try {
            // Record an observation
            Observation observation = AstronomicalObservationUtils.recordObservation("2023-06-24", "Mars", new BigDecimal("78340000"));
            System.out.println("Recorded Observation: " + observation);

            // Calculate the distance in AU
            BigDecimal distanceInAU = AstronomicalObservationUtils.calculateDistanceInAU(observation.distanceKm());
            System.out.println("Distance to " + observation.celestialBody() + " in AU: " + distanceInAU);

        } catch (Exception e) {
            System.out.println("An error occurred while processing the observation.");
        }

        try {
            // Attempt to record an observation with a future date
            Observation futureObservation = AstronomicalObservationUtils.recordObservation("2025-12-01", "Jupiter", new BigDecimal("628730000"));
            System.out.println("Recorded Observation: " + futureObservation);
        } catch (Exception e) {
            System.out.println("An error occurred while processing the future observation.");
        }
    }
}
