'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.replace(/\s*$/, '')
    .split('\n')
    .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

//Complete the minimumLoss function below.
function minimumLoss(prices) {
    let n = prices.length;
    let pricesMap = new Map();

    for (let i = 0; i < n; i++) {
        pricesMap.set(prices[i], i);
    }
    prices.sort((a, b) => a - b);

    let result = Infinity;
    for (let i = 0; i < n-1; i++) {
        if (prices[i+1] - prices[i] < result) {
            if (pricesMap.get(prices[i+1]) < pricesMap.get(prices[i]))
                result = prices[i+1] - prices[i];
        }
    }

    return result;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const n = parseInt(readLine(), 10);

    const price = readLine().split(' ').map(priceTemp => parseInt(priceTemp, 10));

    let result = minimumLoss(price);

    ws.write(result + "\n");

    ws.end();
}
