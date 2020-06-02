package foundation.lang.terminator.tree.expression;

import foundation.rpg.common.symbols.Identifier;

public class ArrayAccess implements Expression {

    private final Expression target;
    private final Expression index;


    public ArrayAccess(Expression target, Expression index) {
        this.target = target;
        this.index = index;
    }
}
