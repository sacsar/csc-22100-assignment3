package csc22100.rpn_calculator;


import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RpnCalculatorTest implements WithAssertions {

    @Test
    void testSimple() {
        List<Element> operations = List.of(new NumberElement(2), new NumberElement(2), BinaryOperator.PLUS);

        RpnCalculator calculator = new RpnCalculator();
        calculator.pushAll(operations);
        assertThat(calculator.completed()).isTrue();
        assertThat(calculator.getResult()).isEqualTo(4.0);
    }

    @Test
    void testSumMultiple() {
        List<Element> operations = List.of(new NumberElement(2), new NumberElement(2), new NumberElement(2), BinaryOperator.PLUS,
                BinaryOperator.TIMES);

        RpnCalculator calculator = new RpnCalculator();
        calculator.pushAll(operations);
        assertThat(calculator.completed()).isTrue();
        assertThat(calculator.getResult()).isEqualTo(8.0);
    }

}