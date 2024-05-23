package br.com.erudio.math;

public class SimplesMath {

	public static Double sum(Double numberOne, Double numberTwo) throws Exception {
		return numberOne + numberTwo;
	}

	public static Double subtraction(Double numberOne, Double numberTwo) throws Exception {
		return numberOne - numberTwo;
	}

	public static Double division(Double numberOne, Double numberTwo) throws Exception {
		return numberOne / numberTwo;
	}

	public static Double multiplication(Double numberOne, Double numberTwo) throws Exception {
		return numberOne * numberTwo;
	}

	public static Double sqrt(Double numberOne) throws Exception {
		return Math.sqrt(numberOne);
	}

	public static Double mean(Double numberOne, Double numberTwo) throws Exception {
		return (numberOne + numberTwo) / 2;
	}

}
