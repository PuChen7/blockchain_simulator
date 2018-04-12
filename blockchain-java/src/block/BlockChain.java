/**
 * This program simulates the blockchain structure.
 *
 * @author  Pu Chen
 * @version 1.0
 * @since   2018-4-10
 */

package block;

import java.util.*;

public class BlockChain {
    ArrayList chain = new ArrayList();

    public BlockChain(){
        Block b = new Block();
        chain.add(b.genesis());
    }

    public Block addBlock(ArrayList data){
        Block lastBlock = (Block)this.chain.get(this.chain.size()-1);
        Block newBlock = new Block();
        newBlock = newBlock.mineBlock(lastBlock, data);
        chain.add(newBlock);
        return newBlock;
    }

}
