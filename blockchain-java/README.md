# Blockchain - Java Version
## Other Versions
[Javascript Version](https://github.com/PuChen7/blockchain_simulator/tree/master/blockchain-javascript)

[Python Version](https://github.com/PuChen7/blockchain_simulator/tree/master/blockchain_python)

## Introduction
### Block has following properties
* Timestamp
* lastHash - the hash of the previous block 
* hash - hash based on its own data
* data
* nonce - used in proof of work
* difficulty

### Generating Hash
Block hash is generated by combination of `timestamp, lastHash, data, nonce, difficulty`. 

The program combines `timestamp, lastHash, data, nonce, difficulty` into one String.

The `Hashing` function:

```java
MessageDigest digest = MessageDigest.getInstance("SHA-256");
```

### Adding Block
First, the program gets the last block in the chain, and call `mineBlock()` which returns the newly generated block, then push the new block into the chain.

### Mining Blocks `(Proof of Work)`
Mining time is controlled by `DIFFICULTY` and `MINE_RATE` in a `do-while` loop. 

`DIFFICULTY` is used for determining how many leading zeros the unique hash contains. It will be recalculated based on the timestamps.

`MINE_RATE` is set to 3000 milliseconds(3 seconds) initially which means it should take around `MINE_RATE` for mining the new block.

### Multiple Chains Validation (Longer Chains)
When multiple miners adding new chains, the system needs to determine which chain is valid and should be accepted. 

The chain which is the `longest` will be accepted. 

### Testing
The project uses `JUnit4` as the testing tool.