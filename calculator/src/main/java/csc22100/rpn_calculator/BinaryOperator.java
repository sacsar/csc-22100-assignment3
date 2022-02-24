package csc22100.rpn_calculator;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Stack;

public enum BinaryOperator implements OperatorElement {

    PLUS("+") {
        double apply(double a, double b) {
            return a + b;
        }
    },
    MINUS("-") {
        double apply(double a, double b) {
            return a - b;
        }
    },
    TIMES("*") {
        double apply(double a, double b) {
            return a * b;
        }
    },
    DIVIDE("/") {
        double apply(double a, double b) {
            return a / b;
        }
    };

    // NOTE: Enums can have fields and constructors and methods, just like classes.
    private final String token;

    BinaryOperator(String token) {
        this.token = token;
    }

    /**
     * Apply the operator to two doubles.
     */
    abstract double apply(double a, double b);

    @Override
    public String getToken() {
        return token;
    }

    public Stack<Element> accept(Stack<Element> elements) {
        throw new NotImplementedException();
    }
}
