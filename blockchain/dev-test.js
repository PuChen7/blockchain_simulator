// require the module
const Block = require('./block');

const block = new Block('foo', 'bar', 'zoo', 'aaa');

console.log(block.toString());