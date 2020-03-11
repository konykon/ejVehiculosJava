package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

	public static void main(String[] args) {

		// Fase 1
		Scanner in = new Scanner(System.in);

		boolean isBrandOk = false;

		String vehicleSelection;
		String plate;
		String brand;
		String color;

		Car myCar;
		Bike myBike;

		System.out.println("Car or bike: ");
		vehicleSelection = in.next();

		System.out.println("Introduce la marca del vehiculo: ");
		brand = in.next();
		System.out.println("Introduce el color del vehiculo: ");
		color = in.next();

		do {
			System.out.println("Introduce la matricula del vehiculo: ");
			plate = in.next().toUpperCase();

			Matcher m = Pattern.compile("^[0-9]{4}[A-Z]{2,3}$").matcher(plate);
			isBrandOk = m.find();
			if (!isBrandOk) {
				System.out.println("invalid");
			}
		} while (isBrandOk == false);

		if (vehicleSelection.equals("car")) {
			myCar = new Car(plate, brand, color);

			List<Wheel>frontWheels = new ArrayList();
			System.out.println("Introduce ruedas traseras: ");
			frontWheels.add(CreateWheel(in));
			frontWheels.add(CreateWheel(in));

			List<Wheel>backWheels = new ArrayList();
			System.out.println("Introduce ruedas delanteras: ");
			backWheels.add(CreateWheel(in));
			backWheels.add(CreateWheel(in));
			try {
				myCar.addWheels(frontWheels, backWheels);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("car " + myCar.toString());
		} else {
			myBike = new Bike(plate, brand, color);

			System.out.println("Introduce rueda trasera: ");
			myBike.wheels.add(CreateWheel(in));

			System.out.println("Introduce rueda delantera: ");
			myBike.wheels.add(CreateWheel(in));

			System.out.println("bike " + myBike.toString());
		}

	}

	public static Wheel CreateWheel(Scanner in) {
		System.out.println("Introduce la marca de la rueda: ");
		String brandW = in.next();
		System.out.println("Introduce el diametro de la rueda: ");
		double diameter = in.nextDouble();

		Wheel wheel = new Wheel(brandW, diameter);

		return wheel;
	}

}
