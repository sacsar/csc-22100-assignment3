package csc22100.rpn_calculator;

import java.util.Stack;

public interface Element {

    boolean isOperator();

    double getValue();

    Stack<Element> apply(Stack<Element> stack);
}
