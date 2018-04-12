package block;

import java.util.ArrayList;

public class TestMain {
    public static void main(String args[]){
        BlockChain a = new BlockChain();
        Block added = a.addBlock(new ArrayList());
        String res = added.toString();
        System.out.println(res);

    }
}
