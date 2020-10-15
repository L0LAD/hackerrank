'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

/*
 * Complete the 'pickingNumbers' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY a as parameter.
 */

function pickingNumbers(a) {
    a.sort();
    let map = new Map();
    let currentNum = 0;

    for (let i=0; i < a.length; i++) {
        if (a[i] != currentNum) {
            currentNum = a[i];
            map.set(currentNum, 1);
        } else
            map.set(currentNum, map.get(currentNum)+1);
    }

    let result = 0;
    let previousKey = -1;
    for (const [key, value] of map.entries()) {
        if ((key - previousKey) == 1 && (value + map.get(previousKey) > result)) {
            result = value + map.get(previousKey);
        }
        previousKey = key;
    }

    //return Math.max(...map.values());
    return result;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const n = parseInt(readLine().trim(), 10);

    const a = readLine().replace(/\s+$/g, '').split(' ').map(aTemp => parseInt(aTemp, 10));

    const result = pickingNumbers(a);

    ws.write(result + '\n');

    ws.end();
}
