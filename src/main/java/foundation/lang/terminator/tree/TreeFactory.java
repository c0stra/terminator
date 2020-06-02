package foundation.lang.terminator.tree;

import foundation.lang.terminator.tree.definition.Definition;
import foundation.lang.terminator.tree.expression.*;
import foundation.lang.terminator.tree.statement.Assignment;
import foundation.lang.terminator.tree.statement.Block;
import foundation.lang.terminator.tree.statement.Termination;
import foundation.lang.terminator.tree.statement.Statement;
import foundation.lang.terminator.unit.Unit;
import foundation.rpg.Match;
import foundation.rpg.StartSymbol;
import foundation.rpg.common.Patterns;
import foundation.rpg.common.precedence.*;
import foundation.rpg.common.precedence.LogicalAnd;
import foundation.rpg.common.rules.*;
import foundation.rpg.common.symbols.*;
import foundation.rpg.parser.Token;

import java.util.List;

public class TreeFactory implements WhiteSpaceRules, ListRules {

    Unit is(@List1 List<Definition> l) { return new Unit(l); }

    @StartSymbol(parserClassName = "TerminatorParser")
    Block is1(@List1 List<Statement> l) { return new Block(l); }

    Statement is (MemberSelect i, Equal a, Expression e, Dot d) { return new Assignment(i, e); }
    Statement is (ArrayAccess i, Equal a, Expression e, Dot d) { return new Assignment(i, e); }
    Statement is (@CommaSeparatedNonEmpty List<Expression> e, Dot d) { return new Termination(e); }

    Expression is (@Ternary Expression e) { return e; }
    @Ternary Expression is(@LogicalOr Expression c, Quest o1, @Ternary Expression t, Colon o2, @Ternary Expression f) { return new TernaryOperation(c, t, f); }
    @LogicalOr Expression is(@LogicalOr Expression l, PipePipe o, @LogicalAnd Expression r) { return new Or(l, r); }
    @LogicalAnd Expression is(@LogicalAnd Expression l, AmpAmp o, @Relational Expression r) { return new And(l, r); }

    @Relational Expression is(@Relational Expression l, EqualEqual o, @Additive Expression r) { return new EqualRelation(l, r); }
    @Relational Expression is(@Relational Expression l, Lt o, @Additive Expression r) { return new LessRelation(l, r); }
    @Relational Expression is(@Relational Expression l, Gt o, @Additive Expression r) { return new GreaterRelation(l, r); }
    @Relational Expression is(@Relational Expression l, ExclEqual o, @Additive Expression r) { return new Negation(new EqualRelation(l, r)); }
    @Relational Expression is(@Relational Expression l, GtEqual o, @Additive Expression r) { return new Negation(new LessRelation(l, r)); }
    @Relational Expression is(@Relational Expression l, LtEqual o, @Additive Expression r) { return new Negation(new GreaterRelation(l, r)); }

    @Additive Expression is(@Additive Expression l, Plus o, @Multiplicative Expression r) { return new Addition(l, r); }
    @Additive Expression is(@Additive Expression l, Minus o, @Multiplicative Expression r) { return new Subtraction(l, r); }

    @Multiplicative Expression is(@Multiplicative Expression l, Star o, @Unary Expression r) { return new Multiplication(l, r); }
    @Multiplicative Expression is(@Multiplicative Expression l, Div o, @Unary Expression r) { return new Division(l, r); }

    @Unary Expression is(Excl o, @Unary Expression e) { return new Negation(e); }
    @Unary Expression is(Minus o, @Unary Expression e) { return new Inversion(e); }
    @Unary Expression is1(@Primary Expression e) { return e; }

    @Primary Expression is(MethodCall e) { return e; }
    @Primary Expression is(MemberSelect e) { return e;}
    @Primary Expression is(ArrayAccess e) { return e; }
    MethodCall is(MemberSelect t, LPar l, @List3 List<Expression> p, RPar r) { return new MethodCall(t, p); }
    ArrayAccess is(@Primary Expression t, LBr l, Expression i, RBr r) { return new ArrayAccess(t, i); }
    MemberSelect is(@Primary Expression t, Identifier i) { return new MemberSelect(t, i); }
    MemberSelect is(Identifier i) { return new MemberSelect(null, i); }
    @Primary Expression is3(@Atomic Expression e) {return e;}

    @Atomic Expression is(String v) { return new Literal<>(v); }
    @Atomic Expression is(Double v) { return new Literal<>(v); }
    //@Atomic Expression is(Long v) { return new Literal<>(v); }
    @Atomic Expression is(Integer v) { return new Literal<>(v); }
    //@Atomic Expression is(Float v) { return new Literal<>(v); }
    //@Atomic Expression is(Short v) { return new Literal<>(v); }
    //@Atomic Expression is(Byte v) { return new Literal<>(v); }
    @Atomic Expression is(Character v) { return new Literal<>(v); }
    @Atomic Expression is(True t) { return new Literal<>(true); }
    @Atomic Expression is(False t) { return new Literal<>(false); }
    @Atomic Expression is(LPar l, Expression e, RPar r) { return e; }

    String aString(@Match(Patterns.DOUBLE_QUOTED_STRING)Token t) { return t.toString().substring(1, t.length() - 1); }
    Double aDouble(@Match(Patterns.DOUBLE) Token t) { return Double.parseDouble(t.toString()); }
    Integer anInt(@Match(Patterns.INTEGER) Token t) { return Integer.parseInt(t.toString()); }
    Character aChar(@Match("'([^\\\\']|\\\\[\\\\'rntfb])'") Token t) { return t.toString().charAt(0); }

}
