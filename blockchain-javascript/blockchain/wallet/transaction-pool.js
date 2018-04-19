const Transaction = require('../wallet/transaction');

class TransactionPool {
    constructor(){
        this.transactions = [];
    }

    /**
     * The function adds transaction one at a time. If the transaction exists in the pool, it replace it with the new one.
     * @param {object} transaction - transaction object
     */
    updateOrAddTransaction(transaction){
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

    validTransactions() {
        return this.transactions.filter(transaction => {
            const outputTotal = this.transactions.outputs.reduce((total, output) => {
                return total + output.amount;   // get the total amount
            }, 0);

            if (transaction.input.amount !== outputTotal) {
                console.log(`Invalid transaction from ${transaction.input.address}.`);
                return;
            }

            if (!Transaction.verifyTransaction(transaction)){
                console.log(`Invalid signature from ${transaction.input.address}.`);
                return;
            }

            return transaction;
        });
    }

    clear() {
        this.transactions = [];
    }
}

module.exports = TransactionPool;