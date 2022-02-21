package csc22100.rpn_calculator;

import java.util.Stack;

public class NumberElement implements Element {

    private final double value;

    public NumberElement(double value) {
        this.value = value;
    }

    @Override
    public boolean isOperator() {
        return false;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public Stack<Element> apply(Stack<Element> stack) {
        throw new RpnException();
    }
}
