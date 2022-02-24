package csc22100.rpn_calculator;

import org.apache.commons.lang3.NotImplementedException;

public interface OperatorElement extends Element {
    String getToken();

    default double getValue() {
        throw new NotImplementedException();
    }

    default String toDisplayString() {
        return getToken();
    }
}
