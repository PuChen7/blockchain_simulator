class TransactionPool {
    constructor(){
        this.transactions = [];
    }

    /**
     * The function adds transaction one at a time. If the transaction exists in the pool, it replace it with the new one.
     * @param {object} transaction - transaction object
     */
    updateOrAddTransactions(transaction){
        // check if transaction exists in the pool, replace if does
        let transactionWithId = this.transactions.find(t => t.id === transaction.id);

        if (transactionWithId){
            this.transactions[this.transactions.indexOf(transactionWithId)] = transaction;
        } else {
            this.transactions.push(transaction);
        }
    }

    existingTransaction(address){
        // t represents each transaction in transactions array.
        return this.transactions.find(t => t.input.address === address);
    }
}

module.exports = TransactionPool;