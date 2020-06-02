package foundation.lang.terminator.tree.expression;

public class ClosureAccess implements Expression {
    private final String name;

    public ClosureAccess(String name) {
        this.name = name;
    }
}
