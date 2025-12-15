import model.entities.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a data do seu checkin (XX/XX/2025): ");
            LocalDate checkin = LocalDate.parse(sc.nextLine(), fmt);

        System.out.println("Digite a data de checkout (XX/XX/2025): ");
            LocalDate checkout = LocalDate.parse(sc.nextLine(), fmt);


        Reservation res = new Reservation(1, checkin, checkout);


        System.out.println(res);
    }


}
