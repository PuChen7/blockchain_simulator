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
    private ArrayList<Block> chain = new ArrayList();

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
        this.chain.add(newBlock);
        return newBlock;
    }

    /**
     * This method tests if the chain is valid by traversing though the chain
     * and check if the current block's hash == previous block's hash.
     * @param chain
     * @return boolean
     */
    public boolean isValidChain(ArrayList<Block> chain){
        for (Block block : chain){
            if (chain.indexOf(block) == 0) continue;

            Block prevBlock = chain.get(chain.indexOf(block) - 1);
            if (prevBlock.getHash().compareTo(block.getLastHash()) != 0 || block.getHash().compareTo(block.blockHash(block)) != 0) return false;
        }
        return true;
    }

    /**
     * This method display the entire chain.
     * */
    public void displayChain(){
        for (Block ele : this.chain){
            System.out.println(ele + "\n");
        }
    }

    /** Getter method for getting the chain */
    public ArrayList<Block> getChain(){ return chain; }

}
