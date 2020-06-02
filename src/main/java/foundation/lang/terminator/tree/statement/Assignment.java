package foundation.lang.terminator.tree.statement;

import foundation.lang.terminator.tree.expression.Expression;

public class Assignment implements Statement {
    private final Expression target;
    private final Expression expression;

    public Assignment(Expression target, Expression expression) {
        this.target = target;
        this.expression = expression;
    }

}
