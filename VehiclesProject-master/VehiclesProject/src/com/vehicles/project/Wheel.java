package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		checkDiameter(diameter);
		this.brand = brand;
		this.diameter = diameter;
	}

	@Override
	public String toString() {
		return "Wheel [brand=" + brand + ", diameter=" + diameter + "]";
	}
	
	public void checkDiameter(double diameter) {
		if (!(diameter>0.4 && diameter<4)) {
			try {
				throw new Exception("El diametro no esta entre 0.4 y 4");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wheel other = (Wheel) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (Double.doubleToLongBits(diameter) != Double.doubleToLongBits(other.diameter))
			return false;
		return true;
	}
	
	
}
