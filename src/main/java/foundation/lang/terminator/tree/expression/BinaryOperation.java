package foundation.lang.terminator.tree.expression;

public abstract class BinaryOperation implements Expression {

    private final Expression left;
    private final Expression right;

    public BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

}
