package foundation.lang.terminator.tree.definition;

import foundation.lang.terminator.tree.statement.Statement;
import foundation.rpg.common.symbols.Identifier;

import java.util.List;

public class MethodDef extends Definition {
    private final String name;
    private final List<Identifier> parameters;
    private final Statement body;
    public MethodDef(String name, List<Identifier> parameters, Statement body) {
        this.name = name;
        this.parameters = parameters;
        this.body = body;
    }
}
