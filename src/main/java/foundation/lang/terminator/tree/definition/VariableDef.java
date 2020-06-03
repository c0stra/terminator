package foundation.lang.terminator.tree.definition;

import foundation.lang.terminator.tree.expression.Expression;

public class VariableDef extends Definition {
    private final String name;
    private final Expression value;

    public VariableDef(String name, Expression value) {
        this.name = name;
        this.value = value;
    }
}
