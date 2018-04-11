class Miner{
    constructor(blockchain, transactionPool, wallet, p2pServer) {
        this.blockchain = blockchain;
        this.transactionPool = transactionPool;
        this.wallet = wallet;
        this.p2pServer = p2pServer;
    }

    mine() {
        /** Steps:
         * get transactions from the pool
         * then create a block whose data consists of those transactions
         * then tell p2p server to synchronize the chains and the new block with those transactions
         * finally it should tell the transaction pool to clear itself of all of transactions because they are added to the blockchain
        */
        const validTransactions = this.transactionPool.validTransactions();
        // include a reward for the miner
        // create a block consisting the valid transactions
        // synchronize chains in the peer to peer server
        // clear the transactions pool
        // broadcast to every miner to clear their transaction pools
    }
}

module.exports = Miner;