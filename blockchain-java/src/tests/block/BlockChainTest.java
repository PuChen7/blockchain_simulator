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

        String hash = a.getChain().get(0).getHash();
        String lastHash = a.getChain().get(1).getLastHash();

        assertEquals(a.isValidChain(a.getChain()), true);
    }
}