package com.hotel.enumerations;

public enum PaymentMethod {
    TARJETA_CREDITO("Tarjeta crédito"),
    TARJETA_DEBITO("Tarjeta débito"),
    DINERO_EFECTIVO("Efectivo");

    private final String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}