const Block = require('./block');

class Blockchian{
    constructor(){
        this.chain = [Block.genesis()];
    }

    addBlock(data){
        const lastBlock = this.chain[this.chain.length-1]; // get the last block in this chain
        const block = Block.mineBlock(lastBlock, data); // new block
        this.chain.push(block); // add the new block
        return block;
    }

    isValidChain(chain){
        if (JSON.stringify(chain[0]) !== JSON.stringify(Block.genesis())) return false;

        for (let i = 1; i<chain.length; i++){
            const block = chain[i];
            const lastBlock = chain[i-1];
            if (block.lastHash !== lastBlock.hash || block.hash !== Block.blockHash(block)) return false;
        }
        return true;
    }

    replaceChain(newChain){
        if (newChain.length <= this.chain.length){
            console.log("not longer than the current chain");
            return;
        } else if (!this.isValidChain(newChain)){
            console.log("The received chain is not valid.");
            return;
        }
        console.log("replacing");
        this.chain = newChain;
    }
}

module.exports = Blockchian;