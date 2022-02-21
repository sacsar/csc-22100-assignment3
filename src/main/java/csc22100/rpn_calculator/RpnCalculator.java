package csc22100.rpn_calculator;

import java.util.List;
import java.util.Stack;

public class RpnCalculator {

    private Stack<Element> stack = new Stack<>();

    public void push(Element element) {
        if (element == null) {
            // duplicate the last element on the stack
            Element lastElt = stack.peek();
            stack.push(lastElt);
        } else if (element.isOperator()) {
            stack = element.apply(stack);
        } else {
            stack.push(element);
        }
    }

    public void pushAll(List<Element> elements) {
        for (Element el : elements) {
            push(el);
        }
    }

    public boolean completed() {
        return stack.size() == 1;
    }

    public double getResult() {
        if (!completed()) {
            throw new IllegalStateException("Calculation is not complete!");
        }
        return stack.get(0).getValue();
    }
}
