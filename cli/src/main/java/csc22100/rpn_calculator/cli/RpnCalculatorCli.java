package csc22100.rpn_calculator.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A CLI that runs the calculator
 */
@SpringBootApplication
public class RpnCalculatorCli {
    /**
     * The main method
     *
     * @param args an array of command line args <describe the arguments>
     */
    public static void main(String[] args) {
        SpringApplication.run(RpnCalculatorCli.class, args);
    }
}
