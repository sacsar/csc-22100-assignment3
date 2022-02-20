package csc22100.rpn_calculator;

import java.util.Stack;

public enum BinaryOperator  {

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

    Stack<Element> apply(Stack<Element> elements) {
        // We just popped off the stack. The inputs are the previous two elements.
        if (elements.size() < 2) {
            throw new RpnException();
        }
        // if the last element is an operator, we need it to process
        while (elements.peek().isOperator()) {
            Element nextOp = elements.pop();
            nextOp.process(elements);
        }
        Element left = elements.pop();
        // once again, we need to clear the operators
        while (elements.peek().isOperator()) {
            Element nextOp = elements.pop();
            nextOp.process(elements);
        }
        Element right = elements.pop();
        double result = apply(left.getValue(), right.getValue());
        elements.push(new NumberElement(result));
        return elements;
    }

    public boolean isOperator() {
        return true;
    }

    abstract double apply(double a, double b);
}
