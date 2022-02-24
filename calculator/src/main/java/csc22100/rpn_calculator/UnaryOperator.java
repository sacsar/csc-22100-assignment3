package csc22100.rpn_calculator;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Stack;

public enum UnaryOperator implements OperatorElement{
    ;
    @Override
    public Stack<Element> accept(Stack<Element> stack) {
        throw new NotImplementedException();
    }

    @Override
    public String getToken() {
        return name();
    }
}
