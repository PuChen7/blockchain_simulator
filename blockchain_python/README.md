# Blockchain - Python Version
## Other Versions
[Java Version](https://github.com/PuChen7/blockchain_simulator/tree/master/blockchain-java)

[Javascript Version](https://github.com/PuChen7/blockchain_simulator/tree/master/blockchain-javascript)

## Introduction
The `Python Version` has simpler implementation than `JavaScript Version` but with the same design idea. 

### Block has following properties
* Timestamp
* lastHash - the hash of the previous block 
* hash - hash based on its own data
* data
* nonce - used in proof of work
* difficulty

### Generating Hash
Using `SHA256` to generate hash based on block.

### Consensus Algorithm
Replace with the `longest chain` to resolve `conflicts`.

### Network
Network is built based on Flask API. 
* `/transactions/new` - POST => add new `transactions`

* `/chain` - GET => return full blockchain

* `/nodes/register` - POST => add nodes to the chain

* `/nodes/resolve` - GET => resolve conflicts