package csc22100.rpn_calculator;

import java.util.Stack;

public enum BinaryOperator implements OperatorElement {

    PLUS {
        public double apply(double a, double b) {
            return a + b;
        }
    },
    MINUS {
        public double apply(double a, double b) {
            return a - b;
        }
    },
    TIMES {
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIVIDE {
        public double apply(double a, double b) {
            return a / b;
        }
    };

    public Stack<Element> apply(Stack<Element> elements) {
        if (elements.size() < 2) {
            throw new IllegalStateException(String.format("Cannot apply operator %s to %s", this, elements));
        }

        double left = elements.pop().getValue();
        double right = elements.pop().getValue();

        elements.push(new NumberElement(apply(left, right)));
        return elements;
    }

    abstract double apply(double a, double b);
}
