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

    // add to the equation when a button is pressed
    public void pressNumber(int number) {
        currentEquation += number;
    }

    // the operator functions just type in their respective symbol when called.
    public void add() {
        currentEquation += " ";
        currentEquation += "+";
    }
    public void subtract() {
        currentEquation += " ";
        currentEquation += "-";
    }
    public void divide() {
        currentEquation += " ";
        currentEquation += "/";
    }
    public void multiply() {
        currentEquation += " ";
        currentEquation += "*";
    }

    // adds a bracket. If the argument is true, '(' is inputted; otherwise a ')' is used.
    public void bracket(boolean isLeft) {
        if(isLeft) {
            currentEquation += " "; // add a space before the left bracket
            currentEquation += "(";
        } else currentEquation += ")";
    }

    // adds a decimal. only works if the previous char is a number.
    // todo: change how this works; if the previous char is not a number, add a space and a zero before the decimal.
    public void decimal() {
        if(currentEquation.charAt(currentEquation.length() - 1) >= '0' && currentEquation.charAt(currentEquation.length() - 1) <= '9') { // if the latest character is a number
            currentEquation += ".";
        }
    }

    // starts the square root function. we can assume users are smart enough to add an ending parenthesis, although later on it might auto-complete.
    public void root() {
        currentEquation += " ";
        currentEquation += "sqrt(";
    }

    // adds a square root symbol. later on, we might replace the ^ symbol (and the exponent) with a small number at the top (like you would normally see it).
    public void square() {
        currentEquation += "^";
    }

    // compute when the enter key is pressed; also updates the answer field to the result.
    public void finish() {
        Expression e = new ExpressionBuilder(currentEquation).build();
        double result = e.evaluate();
        currentAnswer = Double.toString(result);
    }

    // clear everything
    public void clear() {
        currentEquation = "";
        currentAnswer = "";
    }

    public String getCurrentEquation() {
        return currentEquation;
    }
    public String getCurrentAnswer() { return currentAnswer; }
}
