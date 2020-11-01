package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {

			
			
			System.out.print("Room Number: ");
			int roomNumber = sc.nextInt();

			System.out.print("Checkin Date dd/MM/yyyy ");
			Date checkIn = sdf.parse(sc.next());

			System.out.print("CheckOut Date dd/MM/yyyy ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);

			System.out.println(reservation);

			System.out.println("Update reservation");

			System.out.print("enter updated Checkin Date dd/MM/yyyy ");
			checkIn = sdf.parse(sc.next());

			System.out.print("enter updated CheckOut Date dd/MM/yyyy ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);

			System.out.println("Updated data: " + reservation);

		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainExceptions e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Input format error");
		} catch (RuntimeException e) {

			System.out.println("Erro inesperado " + e);

		}

		sc.close();
	}

}
