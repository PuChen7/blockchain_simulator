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

        String hash = a.chain.get(0).getHash();
        String lastHash = a.chain.get(1).getLastHash();

        assertEquals(hash.compareTo(lastHash) == 0, true);
    }
}