package block;
/**
 * This program simulates the blockchain structure.
 *
 * @author  Pu Chen
 * @version 1.0
 * @since   2018-4-10
 */

import chainutil.*;
import java.security.MessageDigest;
import java.sql.*;
import java.util.*;
import javax.xml.bind.DatatypeConverter;

public class Block {
    // private fields
    private Timestamp timestamp;
    private String lastHash;
    private String hash;
    private ArrayList data = new ArrayList();
    private int nonce;
    private int difficulty;

    /** @constructor
     *  timestamp: the unix time
     *  lastHash: hash of the previous block
     *  hash: hash generated by SHA256
     *  data: contains transactions
     *  nonce: used for generating hash
     *  difficulty: the difficulty of mining a block to the chain
     **/
    public Block(Timestamp timestamp, String lastHash, String hash, ArrayList data, int nonce, int difficulty){
        this.timestamp = timestamp;
        this.lastHash = lastHash;
        this.hash = hash;
        this.data = data;
        this.nonce = nonce;
        this.difficulty = difficulty;
    }

    public Block(){}

    /**
     * Returns the first block in the chain
     */
    public Block genesis(){
        return new Block(null, "lastHash", "hash", null, 0, 4);
    }

    /**
     * Generates the hash using SHA-256.
     * @return result - the result of hash
     */
    public String hash(Timestamp timestamp, String lastHash, ArrayList data, int nonce, int difficulty){
        String str = timestamp + lastHash + data + nonce + difficulty;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes("UTF-8"));
            return DatatypeConverter.printHexBinary(hash);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * This method creates a new block.
     * @param lastBlock: the last block
     * @param data: data should contain transactions
     * @return new Block
     */
    public Block mineBlock(Block lastBlock, ArrayList data){
        String lastHash = lastBlock.hash;
        int difficulty = lastBlock.difficulty;
        int nonce = 0;
        String hash;
        Timestamp timestamp;
        String zeros = "0";

        do {
            nonce++;
            timestamp = new Timestamp(System.currentTimeMillis());
            difficulty = this.adjustDifficulty(lastBlock, timestamp);
            hash = this.hash(timestamp, lastHash, data, nonce, difficulty);
        } while (hash.substring(0,difficulty).compareTo(new String(new char[difficulty]).replace("\0", zeros)) != 0);

        return new Block(timestamp, lastHash, hash, data, nonce, difficulty);
    }

    /**
     * This method adjust difficulty according to the timestamp
     * @param lastBlock
     * @param timestamp
     * @return difficulty
     */
    public int adjustDifficulty(Block lastBlock, Timestamp timestamp){
        ChainUtil util = new ChainUtil();
        int difficulty = lastBlock.difficulty;
        // add MINE_RATE to the timestamp
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp.getTime());
        cal.add(Calendar.SECOND, util.MINE_RATE);
        Timestamp res = new Timestamp(cal.getTime().getTime());

        if (res.compareTo(timestamp) > 0)   // if res is after timestamp
            difficulty += 1;
        else
            difficulty -= 1;

        return difficulty;
    }

    /**
     * This method generates the hash of the block.
     * @param b
     * @return hash
     */
    public String blockHash(Block b){
        return this.hash(b.timestamp, b.lastHash, b.data, b.nonce, b.difficulty);
    }

    /**
     * Getter methods
     */
    public Timestamp getTimestamp(){ return this.timestamp; }

    public String getLastHash(){ return this.lastHash; }

    public String getHash(){ return this.hash; }

    public ArrayList getData() { return data; }

    public int getNonce() { return nonce; }

    public int getDifficulty() { return difficulty; }

    /**
     * output formatted block info
     */
    public String toString(){
        String str = "Block -\nTimestamp: " + this.timestamp + "\nLast Hash: "
                + this.lastHash + "\nHash: " + this.hash + "\nNonce: " + this.nonce
                + "\nDifficulty: " + this.difficulty + "\nData: " + this.data;
        return str;
    }
}
