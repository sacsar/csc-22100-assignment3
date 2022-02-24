package csc22100.rpn_calculator;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;
import java.util.Optional;
import java.util.Stack;

public class NumberElement implements Element {

    private final double value;

    public NumberElement(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public Stack<Element> accept(Stack<Element> stack) {
        throw new RpnException();
    }

    public static Optional<NumberElement> parse(String s) {
        try {
            double val = Double.parseDouble(s);
            return Optional.of(new NumberElement(val));
        } catch (NumberFormatException e){
            // not a double
            return Optional.empty();
        } // any other exception, we'll throw
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("value", value)
                        .build();
    }

	@Override
	public String toDisplayString() {
        return Double.toString(value);
	}
}
