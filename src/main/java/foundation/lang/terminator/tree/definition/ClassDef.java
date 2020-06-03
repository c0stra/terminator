package foundation.lang.terminator.tree.definition;

import java.util.List;

public class ClassDef extends TypeDef {
    private final String name;
    private final List<Definition> members;

    public ClassDef(String name, List<Definition> members) {
        this.name = name;
        this.members = members;
    }
}
