package csc22100.rpn_calculator.cli;

import csc22100.rpn_calculator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ShellComponent
public class Commands {

    private static final List<OperatorElement> OPERATORS;

    static {
        OPERATORS = new ArrayList<>();
        OPERATORS.addAll(List.of(BinaryOperator.values()));
        OPERATORS.addAll(List.of(UnaryOperator.values()));
    }

    @Autowired
    private RpnCalculator calculator;

    @Autowired
    private RpnStackDisplayer rpnStackDisplayer;

    @ShellMethod(value="print the calculator's current stack")
    public void show() {
        rpnStackDisplayer.showStack();
    }

    public void processToken(String token) throws ParseException {
        Element element = matchToken(token);
        calculator.push(element);

        show();
    }

    Element matchToken(String token) throws ParseException {
        Optional<NumberElement> numberElementOpt = NumberElement.parse(token);
        if (numberElementOpt.isPresent()) {
            return numberElementOpt.get();
        } else {
            // we ought to have an operator
            Optional<OperatorElement> matchedOperator = OPERATORS.stream().filter(x -> x.getToken().equals(token)).findFirst();
            if (matchedOperator.isEmpty()) {
                throw new ParseException(String.format("Unable to parse input %s", token), 0);
            }
            return matchedOperator.get();
        }
    }
}
