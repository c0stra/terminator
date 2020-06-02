package foundation.lang.terminator.tree.expression;

public class UnaryExpression implements Expression {
    private final Expression operand;

    public UnaryExpression(Expression operand) {
        this.operand = operand;
    }

}
