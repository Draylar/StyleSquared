package com.github.draylar;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorManager {

    // ----------- SINGLETON PATTERN ---------------- //

    private static CalculatorManager instance;

    private CalculatorManager() {  }

    public static CalculatorManager getInstance() {
        if(instance == null) instance = new CalculatorManager();
        return instance;
    }


    // -------------- MECHANICS ------------------ //

    // hold the current equation & answer in a string
    private String currentEquation = "";
    private String currentAnswer = "";

    /**
     * Adds the arguments' number to the current equation.
     * @param number the number that was pressed
     */
    public void pressNumber(int number) { currentEquation += number; }


    /**
     * Adds the addition operator (+) to the current equation.
     */
    public void add() { currentEquation += "+"; }


    /**
     * Adds the subtraction operator (-) to the current equation.
     */
    public void subtract() { currentEquation += "-"; }


    /**
     * Adds the division operator (/) to the current equation.
     */
    public void divide() {
        currentEquation += "/";
    }


    /**
     * Adds the multiplication operator (*) to the current equation.
     */
    public void multiply() {
        currentEquation += "*";
    }


    /**
     * Adds a bracket to the current equation. If isLeft is true, the bracket is (, otherwise it is ).
     * @param isLeft is the bracket a left bracket?
     */
    public void bracket(boolean isLeft) {
        if(isLeft) {
            currentEquation += "(";
        } else currentEquation += ")";
    }


    // todo: change how this works; if the previous char is not a number, add a space and a zero before the decimal.
    /**
     * Adds a decimal to the current equation.
     */
    public void decimal() {
        if(currentEquation.charAt(currentEquation.length() - 1) >= '0' && currentEquation.charAt(currentEquation.length() - 1) <= '9') { // if the latest character is a number
            currentEquation += ".";
        }
    }


    /**
     * Adds the start of the square root function, 'sqrt(', to the current equation.
     */
    public void root() {
        currentEquation += "sqrt(";
    }


    /**
     * Adds the square symbol, '^', to the current equation.
     */
    public void square() {
        currentEquation += "^";
    }


    /**
     * Adds the pi operator, 'π', to the current equation.
     */
    public void pi() {
        currentEquation += "π";
    }


    /**
     * Adds the modulus operator, '%', to the current equation.
     */
    public void mod() {
        currentEquation += "%";
    }


    /**
     * Adds the start of the log10 function, "log10(", to the current equation.
     */
    public void log10() {
        currentEquation += "log10(";
    }


    /**
     * Adds the start of the absolute value function, "abs(", to the current equation.
     */
    public void absoluteValue() {
        currentEquation += "abs(";
    }


    /**
     * Computes the current equation and updates the answer field to the new results.
     */
    public void finish() {
        Expression e = new ExpressionBuilder(currentEquation).build();
        double result = e.evaluate();
        currentAnswer = Double.toString(result);
    }


    /**
     * Clears the current equation and answer.
     */
    public void clear() {
        currentEquation = "";
        currentAnswer = "";
    }


    /**
     * Retrieves the current equation.
     * @return the current equation
     */
    public String getCurrentEquation() {
        return currentEquation;
    }


    /**
     * Retrieves the current answer.
     * @return the current answer
     */
    public String getCurrentAnswer() { return currentAnswer; }
}
