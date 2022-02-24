package csc22100.rpn_calculator;

import java.util.Stack;

/**
 * Interface for the "elements" that the calculator can understand. Depending on your perspective,
 * we have two or three types of elements;
 * - numbers and operators
 * - numbers, binary operators and unary operators
 */
public interface Element {

    /**
     * Get the value of this element. Throw an exception if it is an operator and not a NumberElement
     */
    double getValue();

    /**
     * Get the string to pretty-print this element in the CLI.
     */
    String toDisplayString();

    /**
     * Given a {@link Stack} of {@link Element} representing the current state of the calculator, apply the current
     * element.
     *
     * This allows us to implement a version of the Visitor pattern (https://refactoring.guru/design-patterns/visitor)
     *
     * @param stack the current stack of the {@link RpnCalculator}
     * @return the updated stack
     */
    Stack<Element> accept(Stack<Element> stack);
}
