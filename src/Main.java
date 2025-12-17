import model.entities.Reservation;
import model.exceptions.DomainExecption;

import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("digite o numero do quarto que voce deseja: ");
            int roomNumber = sc.nextInt();
            sc.nextLine();

            System.out.println("Digite a data do seu checkin (XX/XX/2025): ");
            LocalDate checkin = LocalDate.parse(sc.nextLine(), fmt);

            System.out.println("Digite a data de checkout (XX/XX/2025): ");
            LocalDate checkout = LocalDate.parse(sc.nextLine(), fmt);


            Reservation res = new Reservation(roomNumber, checkin, checkout);

            System.out.println(res);


            System.out.println("Digite a data atualizada do seu checkin (XX/XX/2025): ");
            checkin = LocalDate.parse(sc.nextLine(), fmt);

            System.out.println("Digite a data de checkout atualizada (XX/XX/2025): ");
            checkout = LocalDate.parse(sc.nextLine(), fmt);

            res.updateDates(checkin, checkout);
            System.out.println("DADOS ATUALIZADOS: " + res);
        }
        catch (DateTimeException e) {

            System.out.println("Formatação de data inválida.");

        }
        catch (DomainExecption e) {

            System.out.println("Erro na declaração de argumentos:  " + e.getMessage());

        } catch (RuntimeException e) {

            System.out.println("Erro inesperado");
        }
    }


}
