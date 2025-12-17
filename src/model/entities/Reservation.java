package model.entities;

import model.exceptions.DomainExecption;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private int roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate now = LocalDate.now();

    public Reservation(int roomNumber, LocalDate checkin, LocalDate checkout) {

        if (checkin.isBefore(now) || checkout.isBefore(now) ) {

            throw new DomainExecption("Essa data de reserva já passou");

        } else if (checkin.isAfter(checkout)) {

            throw  new DomainExecption("Checkin está com uma data depois do checkout");

        }

        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;

    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public int getDuration() {

        return (int) ChronoUnit.DAYS.between(checkin, checkout);
    }

    public void updateDates(LocalDate checkin, LocalDate checkout) {

        if (checkin.isBefore(now) || checkout.isBefore(now) ) {

            throw new DomainExecption("Essa data de reserva já passou");

        } else if (checkin.isAfter(checkout)) {

            throw  new DomainExecption("Checkin está com uma data depois do checkout");

        }

        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Room ").append(getRoomNumber()).append(", ");
        sb.append("check-in: ").append(checkin.format(fmt)).append(", ");
        sb.append("check-out: ").append(getCheckout().format(fmt)).append(". ");
        sb.append(getDuration()).append(" nights.");


        return sb.toString();
    }
}
