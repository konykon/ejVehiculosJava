package com.vehicles.project;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {	
		
		// Fase 1
		Scanner in = new Scanner(System.in);
		
		String plate;
		String brand;
		String color;
		
		Car myCar;
		
		System.out.println("Introduce la matricula del coche: ");
		plate = in.next();
		System.out.println("Introduce la marca del coche: ");
		brand = in.next();
		System.out.println("Introduce el color del coche: ");
		color = in.next();
		
		myCar = new Car(plate, brand, color);
		
		System.out.println("Introduce ruedas traseras: ");
		myCar.wheels.add(CreateWheel(in));
		myCar.wheels.add(CreateWheel(in));
		
		System.out.println("Introduce ruedas delanteras: ");
		myCar.wheels.add(CreateWheel(in));
		myCar.wheels.add(CreateWheel(in));
		
		System.out.println(myCar.toString());
		
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