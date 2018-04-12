package block;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;

public class BlockTest {

    @Test
    public void genesis() {
        Block genesis = new Block(null, null, null, new ArrayList(), 0, 5);
    }

    @Test
    public void hash() {
    }

    @Test
    public void blockHash() {
    }
}