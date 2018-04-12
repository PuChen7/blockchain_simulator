package block;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;

public class BlockChainTest {

    @Test
    public void addBlock() {
        BlockChain a = new BlockChain();
        ArrayList data = new ArrayList();
        data.add("transaction1");
        data.add("transaction2");
        a.addBlock(data);

        assertEquals(a.chain.get(0).hash.compareTo(a.chain.get(1).lastHash) == 0, true);
    }
}