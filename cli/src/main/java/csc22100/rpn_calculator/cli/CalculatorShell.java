package csc22100.rpn_calculator.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.CommandNotFound;
import org.springframework.shell.Input;
import org.springframework.shell.ResultHandler;
import org.springframework.shell.Shell;

import java.text.ParseException;
import java.util.Locale;

public class CalculatorShell extends Shell {

    @Autowired
    Commands commands;

    public CalculatorShell(@Autowired ResultHandler resultHandler) {
        super(resultHandler);
    }

    @Override
    public Object evaluate(Input input) {
        Object result = super.evaluate(input);
        if (result instanceof CommandNotFound) {
            // in the case that we didn't match a command, try to parse for the calculator
            String rawInput = input.rawText().trim().toLowerCase(Locale.ROOT);
            try {
                commands.processToken(rawInput);
                return NO_INPUT;
            } catch (ParseException ex) {
                return result;
            }
        }
        return result;
    }
}
