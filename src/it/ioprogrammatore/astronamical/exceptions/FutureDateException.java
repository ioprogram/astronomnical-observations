package it.ioprogrammatore.astronamical.exceptions;

public class FutureDateException extends Exception {
    public FutureDateException() {
        super("Observation date cannot be in the future.");
    }
}
