package it.ioprogrammatore.astronamical.models.records;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Observation(LocalDate date, String celestialBody, BigDecimal distanceKm) { }

