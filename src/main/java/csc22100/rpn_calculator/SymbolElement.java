package csc22100.rpn_calculator;

import java.util.Stack;

public enum SymbolElement implements Element {
    PLUS,
    TIMES,
    DIVIDE,
    MINUS;

    @Override
    public double getValue() {
        throw new IllegalStateException("Cannot return a value for a symbol element!");
    }

    @Override
    public Stack<Element> process(Stack<Element> stack) {
        switch(this) {
            case PLUS:
                return BinaryOperator.PLUS.apply(stack);
            case TIMES:
                return BinaryOperator.TIMES.apply(stack);
            case DIVIDE:
                return BinaryOperator.DIVIDE.apply(stack);
            case MINUS:
                return BinaryOperator.MINUS.apply(stack);
            default:
                throw new IllegalStateException();
        }
    }

    @Override
    public boolean isOperator() {
        return true;
    }
}
