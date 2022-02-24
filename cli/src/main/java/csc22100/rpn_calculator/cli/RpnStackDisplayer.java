package csc22100.rpn_calculator.cli;

import csc22100.rpn_calculator.Element;
import csc22100.rpn_calculator.RpnCalculator;

import java.util.Stack;

import org.jline.terminal.Terminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.table.ArrayTableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.CellMatchers;
import org.springframework.shell.table.Formatter;
import org.springframework.shell.table.Table;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;

public class RpnStackDisplayer {
    @Autowired
    RpnCalculator calculator;

    @Autowired
    Terminal terminal;

    private Table buildTable() {
      Stack<Element> stack = calculator.getStack();

      Object[][] tableRows = { stack.toArray() };

      TableModel tableModel = new ArrayTableModel(tableRows);
      TableBuilder tableBuilder = new TableBuilder(tableModel)
          .addFullBorder(BorderStyle.fancy_light);
      tableBuilder
          .on(CellMatchers.ofType(Element.class))
          .addFormatter(new ElementFormatter());

      return tableBuilder.build();
    }

    public void showStack() {
        terminal.writer().println(buildTable().render(terminal.getWidth()));
        terminal.writer().flush();
    }

    private static class ElementFormatter implements Formatter {

		@Override
		public String[] format(Object value) {
            Element element = (Element) value;
			return new String[]{element.toDisplayString()};
		}

    }
}
