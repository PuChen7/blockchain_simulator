package wallet;

import chainutil.ChainUtil;

import java.security.*;

public class Wallet {
    private double balance;
    private KeyPair keyPair;

    // constructor
    public Wallet(){
        this.balance = ChainUtil.INITIAL_BALANCE;
        /**
         * Using KeyPairGenerator to generate public/private key
         * Further use:
         * Key pub = kp.getPublic();
         * Key pvt = kp.getPrivate();
         */
        try{
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048);
            this.keyPair = keyPairGen.generateKeyPair();
        } catch(NoSuchAlgorithmException e){
            throw new IllegalArgumentException("No such algorithm");
        }
    }



    public Key getPublicKey(){
        return this.keyPair.getPublic();
    }
}
