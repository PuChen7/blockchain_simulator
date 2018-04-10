/**
 * This program simulates the blockchain structure.
 *
 * @author  Pu Chen
 * @version 1.0
 * @since   2018-4-10
 */

import java.security.MessageDigest;
2
import java.util.Scanner;
3
import javax.xml.bind.DatatypeConverter;


public class Block {
    // private fields
    private String timestamp;
    private String lastHash;
    private String hash;
    private String[] data;
    private int nonce;
    private int difficulty;

    // constructor
    public Block(String timestamp, String lastHash, String hash, String[] data, int nonce, int difficulty){
        this.timestamp = timestamp;
        this.lastHash = lastHash;
        this.hash = hash;
        this.data = data;
        this.nonce = nonce;
        this.difficulty = difficulty;
    }

    /**
     * Returns the first block in the chain
     */
    private Block genesis(){
        return new Block("genesis time", "lastHash", "hash", null, 0, this.difficulty);
    }

    /**
     * Generates the hash using SHA-256.
     * @param b - object of Block
     * @return result - the result of hash
     */
    private String hash(Block b){
        String data = b.timestamp + b.lastHash + b.data + b.nonce + b.difficulty;
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            return DatatypeConverter.printHexBinary(hash);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
