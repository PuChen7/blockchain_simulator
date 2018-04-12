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
    /* The chain contains all blocks */
    ArrayList<Block> chain = new ArrayList();

    public BlockChain(){
        Block b = new Block();
        chain.add(b.genesis());
    }

    /**
     * This method adds a block into the blockchain.
     * @param data - the data ArrayList should contain transactions
     * @return newBlock - the newly added block
     * */
    public Block addBlock(ArrayList data){
        Block lastBlock = this.chain.get(this.chain.size()-1);
        Block newBlock = new Block();
        newBlock = newBlock.mineBlock(lastBlock, data);
        chain.add(newBlock);
        return newBlock;
    }



    /**
     * This method display the entire chain.
     * */
    public void displayChain(){
        for (Block ele : chain){
            System.out.println(ele + "\n");
        }
    }

}
