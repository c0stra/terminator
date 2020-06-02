package foundation.lang.terminator;

import foundation.lang.terminator.tree.TerminatorParser;
import foundation.lang.terminator.tree.TreeFactory;
import foundation.lang.terminator.tree.statement.Block;
import org.testng.annotations.Test;

import java.io.IOException;

public class TerminatorTest {

    private final TerminatorParser parser = new TerminatorParser(new TreeFactory());

    @Test
    public void test() throws IOException {
        Block script = parser.parseUrl(getClass().getResource("/terminator/program.t1"));
        System.out.println(script);
    }

}
