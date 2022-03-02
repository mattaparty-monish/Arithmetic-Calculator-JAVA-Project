package project;

import java.util.InputMismatchException;

import java.util.Scanner;

class ArithmeticException extends Exception {
	
	@Override
	public String getMessage() {
		return ("Cannot Divide by 0!");
	}
	
}

class InvalidOperatorException extends Exception {
	String message;
	
	public InvalidOperatorException(String message) {
		super(message);
	}
	
}

class InvalidNumberOfArithmeticCalculationsException extends Exception {
	String message;
	
	public InvalidNumberOfArithmeticCalculationsException(String message) {
		super(message);
	}
	
}

abstract class Calculator {
	abstract void displayWelcomeMessage();
	
	abstract void getInput();
	
	abstract void performCalculation(double firstNumber, char operator, double secondNumber);
}

class ArithmeticCalculator extends Calculator {
	protected double firstNumber, secondNumber, result;
	
	protected char operator;
	
	protected Scanner input = new Scanner(System.in);

	@Override
	void displayWelcomeMessage() {
		// TODO Auto-generated method stub
		
		System.out.println("*************************************************************************************************************************************************************");
		System.out.println("");
		System.out.println("\t\t\t\t\t\t\t\t  Arithmetic Calculator");
		System.out.println("");
		System.out.println("*************************************************************************************************************************************************************");
		System.out.println("");
		
	}
	
	@Override
	void getInput() {
		// TODO Auto-generated method stub
		
		System.out.print("Enter First Number : ");
		
		try {
			firstNumber = input.nextDouble();
		}
		
		catch (InputMismatchException error) {
			System.out.println("");
			System.out.println("Error : Invalid Number Entered! Please Enter A Valid Number.");
			System.out.println("");
			System.out.print("Exiting Arithmetic Calculator......");
			System.exit(0);
		}
		
		System.out.println("");
		System.out.print("Enter Operator (\"+\" for Addition, \"-\" for Subtraction, \"*\" for Multiplication, and \"/\" for Division : ");
		
		try {
			operator = input.next().charAt(0);
			
			if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
				throw new InvalidOperatorException("Invalid Operator Entered! Please Enter A Valid Operator.");
			}
		}
		
		catch (InvalidOperatorException error) {
			System.out.println("");
			System.out.println("Error : " + error.getMessage());
			System.out.println("");
			System.out.print("Exiting Arithmetic Calculator......");
			System.exit(0);
		}
		
		System.out.println("");
		System.out.print("Enter Second Number : ");
		
		try {
			secondNumber = input.nextDouble();
			
			if ((operator == '/') && (secondNumber == 0)) {
				throw new ArithmeticException();
			}
		}
		
		catch (InputMismatchException error) {
			System.out.println("");
			System.out.println("Error : Invalid Number Entered! Please Enter A Valid Number.");
			System.out.println("");
			System.out.print("Exiting Arithmetic Calculator......");
			System.exit(0);
		}
		
		catch (ArithmeticException error) {
			System.out.println("");
			System.out.println("Error : " + error.getMessage());
			System.out.println("");
			System.out.print("Exiting Arithmetic Calculator......");
			System.exit(0);
		}
		
	}

	@Override
	void performCalculation(double firstNumber, char operator, double secondNumber) {
		// TODO Auto-generated method stub
		
		switch (operator) {
			case '+':
				result = firstNumber + secondNumber;
				System.out.println("");
				System.out.print("The Arithmetic Calculation of " + firstNumber + " " + operator + " " + secondNumber + " = " + result);
				break;
				
			case '-':
				result = firstNumber - secondNumber;
				System.out.println("");
				System.out.print("The Arithmetic Calculation of " + firstNumber + " " + operator + " " + secondNumber + " = " + result);
				break;
				
			case '*':
				result = firstNumber * secondNumber;
				System.out.println("");
				System.out.print("The Arithmetic Calculation of " + firstNumber + " " + operator + " " + secondNumber + " = " + result);
				break;
				
			case '/':
				result = firstNumber / secondNumber;
				System.out.println("");
				System.out.print("The Arithmetic Calculation of " + firstNumber + " " + operator + " " + secondNumber + " = " + result);
				break;
				
			default:
				System.out.println("");
				System.out.println("Error : Invalid Operator Entered! Please Enter A Valid Operator.");
				System.out.println("");
				System.out.print("Exiting Arithmetic Calculator......");
				System.exit(0);
		}
		
	}
	
}

public class ArithmeticCalculatorProject {
	
	protected static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numberOfArithmeticCalculations;
		
		ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
		
		arithmeticCalculator.displayWelcomeMessage();
		
		System.out.print("Enter Number of Arithmetic Calculations to be Performed : ");
		
		try {
			numberOfArithmeticCalculations = input.nextInt();
			
			if (numberOfArithmeticCalculations == 0) {
				throw new InvalidNumberOfArithmeticCalculationsException("Invalid Number Entered! Please Enter A Non - Zero Positive Number.");
			}
			
			else if (numberOfArithmeticCalculations < 0) {
				throw new InvalidNumberOfArithmeticCalculationsException("Invalid Number Entered! Please Enter A Positive Number.");
			}
			
			else {
				for (int i = 0; i < numberOfArithmeticCalculations; i ++) {
					arithmeticCalculator.displayWelcomeMessage();
					arithmeticCalculator.getInput();
					arithmeticCalculator.performCalculation(arithmeticCalculator.firstNumber, arithmeticCalculator.operator, arithmeticCalculator.secondNumber);
				}
			}
		}
		
		catch (InputMismatchException error) {
			System.out.println("");
			System.out.println("Error : Invalid Number Entered! Please Enter A Valid Number.");
			System.out.println("");
			System.out.print("Exiting Arithmetic Calculator......");
			System.exit(0);
		}
		
		catch (InvalidNumberOfArithmeticCalculationsException error) {
			System.out.println("");
			System.out.println("Error : " + error.getMessage());
			System.out.println("");
			System.out.print("Exiting Arithmetic Calculator......");
			System.exit(0);
		}
		
	}
	
}
