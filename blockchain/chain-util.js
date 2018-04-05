const EC = require('elliptic').ec;
const SHA256 = require('crypto-js/sha256');
const uuidV1 = require('uuid/v1');  // generate unique id
const ec = new EC('secp256k1');

class ChainUtil{
    static genKeyPair(){
        return ec.genKeyPair();
    }

    static id(){
        return uuidV1();    // return unique id
    }

    static hash(data){
        return SHA256(JSON.stringify(data)).toString();
    }
}

module.exports = ChainUtil;