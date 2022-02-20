package csc22100.rpn_calculator;


import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

class RpnCalculatorTest implements WithAssertions {

    @Test
    void testSimple() {
        Stack<Element> elements = new Stack<>();
        elements.addAll(List.of(new NumberElement(2), new NumberElement(2), SymbolElement.PLUS));

        RpnCalculator calculator = new RpnCalculator();
        assertThat(calculator.calculate(elements)).isEqualTo(4.0);
    }

    @Test
    void testSumMultiple() {
        Stack<Element> elements = new Stack<>();
        elements.addAll(List.of(new NumberElement(2), new NumberElement(2), new NumberElement(2), SymbolElement.PLUS,
                SymbolElement.TIMES));

        RpnCalculator calculator = new RpnCalculator();
        assertThat(calculator.calculate(elements)).isEqualTo(8.0);
    }

}