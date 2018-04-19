const Wallet = require('../wallet');
const Transaction = require('../wallet/transaction');

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
        validTransactions.push(Transaction.rewardTransaction(this.wallet, Wallet.blockchainWallet()));
        // create a block consisting the valid transactions
        const block = this.blockchain.addBlock(validTransactions);
        // synchronize chains in the peer to peer server
        this.p2pServer.syncChains();
        // clear the transactions pool
        this.transactionPool.clear();
        // broadcast to every miner to clear their transaction pools
        this.p2pServer.broadcastClearTransactions();

        return block;
    }
}

module.exports = Miner;