package foundation.lang.terminator.tree.expression;

import foundation.rpg.common.symbols.Identifier;

public class MemberSelect implements Expression {

    private final Expression target;
    private final Identifier identifier;

    public MemberSelect(Expression target, Identifier identifier) {
        this.target = target;
        this.identifier = identifier;
    }

}
