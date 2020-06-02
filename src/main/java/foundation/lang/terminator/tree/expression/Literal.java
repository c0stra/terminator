package foundation.lang.terminator.tree.expression;

public class Literal<T> implements Expression {

    private final T value;

    public Literal(T value) {
        this.value = value;
    }

}
