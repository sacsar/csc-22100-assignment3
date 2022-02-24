package csc22100.rpn_calculator;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * A RPN calculator.
 */
public class RpnCalculator {

    private Stack<Element> stack = new Stack<>();

    /**
     * Push an element onto the stack.
     *
     * @param element the {@link Element} to push
     */
    public void push(Element element) {
        throw new NotImplementedException();
    }

    /**
     * Push a sequence of elements onto the stack.
     *
     * @param elements a List of {@link Element} to push
     */
    public void pushAll(List<Element> elements) {
        for (Element el : elements) {
            push(el);
        }
    }

    /**
     *
     * @return
     */
    public boolean completed() {
        return stack.size() == 1;
    }

    /**
     *
     * @return
     */
    public double getResult() {
        if (!completed()) {
            throw new IllegalStateException("Calculation is not complete!");
        }
        return stack.get(0).getValue();
    }

    public String getStackString() {
        return Arrays.toString(stack.toArray());
    }

    public Stack<Element> getStack() {
        return stack;
    }
}
