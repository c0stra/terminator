package foundation.lang.terminator.tree.expression;

import foundation.rpg.common.symbols.Identifier;

import java.util.List;

public class MethodCall implements Expression {

    private final MemberSelect target;
    private final List<Expression> parameters;

    public MethodCall(MemberSelect target, List<Expression> parameters) {
        this.target = target;
        this.parameters = parameters;
    }

}
