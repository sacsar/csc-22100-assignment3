package csc22100.rpn_calculator.cli;

import csc22100.rpn_calculator.RpnCalculator;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.shell.ResultHandler;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.shell.result.ResultHandlerConfig;

@Configuration
@Import(ResultHandlerConfig.class)
public class RpnCalculatorCliConfig {
    @Bean
    public PromptProvider getPromptProvider() {
        return () -> new AttributedString("calc:> ", AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));
    }

    /**
     * This is a <i>heinous</i> hack to override the standard {@link Shell} so
     * we can keep the standard spring-shell commands while also processing calculator inputs
     */
    @Bean
    @Primary
    @Lazy
    public Shell getShell(@Qualifier("main") ResultHandler<?> resultHandler) {
        return new CalculatorShell(resultHandler);
    }

    @Bean
    public RpnCalculator calculator() {
        return new RpnCalculator();
    }

    @Bean
    public RpnStackDisplayer rpnStackDisplayer() {
        return new RpnStackDisplayer();
    }
}
