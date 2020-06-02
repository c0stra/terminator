package foundation.lang.terminator.tree.statement;

import foundation.lang.terminator.tree.expression.Expression;

import java.util.List;

public class Termination implements Statement {
    private final List<Expression> expression;

    public Termination(List<Expression> expression) {
        this.expression = expression;
    }

}
