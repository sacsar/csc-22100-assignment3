package csc22100.rpn_calculator.cli;

import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

@CommandLine.Command
public class Grader implements Callable<Integer> {

    @CommandLine.Parameters
    File testCases;

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
