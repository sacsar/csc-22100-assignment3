package csc22100.rpn_calculator;

interface OperatorElement extends Element {
    default boolean isOperator() {
        return true;
    }

    default double getValue() {
        throw new IllegalStateException("Operator elements do not have value");
    }
}
