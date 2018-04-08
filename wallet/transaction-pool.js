class TransactionPool {
    constructor(){
        this.transactions = [];
    }

    // incoming transaction object
    updateOrAddTransactions(transaction){
        // check if transaction exists in the pool, replace if does
        let transactionWithId = this.transactions.find(t => t.id === transaction.id);

        if (transactionWithId){
            this.transactions[this.transactions.indexOf(transactionWithId)] = transaction;
        } else {
            this.transactions.push(transaction);
        }
    }
}

module.exports = TransactionPool;