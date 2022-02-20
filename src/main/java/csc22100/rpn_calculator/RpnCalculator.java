package csc22100.rpn_calculator;

import java.util.Stack;

public class RpnCalculator {

    public double calculate(Stack<Element> elements) {
        while (elements.size() > 1) {
            Element element = elements.pop();
            elements = element.process(elements);
        }
        // then when we're done, the last element on the stack better be a number and we return it
        Element finalElement = elements.pop();
        return finalElement.getValue();
    }
}
