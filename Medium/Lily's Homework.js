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

// Complete the lilysHomework function below.
function lilysHomework(mixedArray) {
    var arr = mixedArray.slice();
    var brr = mixedArray.slice();
    mixedArray.sort(function(a, b) {return a-b});

    //Ascending sort
    var aResult = 0;
    var sortedArr = mixedArray.slice();
    var indexArr = [];
    
    for (var i=0; i<arr.length; i++) {
        indexArr[arr[i]] = i;
    }
    
    for (var i=0; i<sortedArr.length; i++) {
        if (sortedArr[i] != arr[i]) {
            var numA = arr[i];
            var numB = sortedArr[i];
            var rankB = indexArr[sortedArr[i]];
            indexArr[sortedArr[i]] = i;
            indexArr[arr[i]] = rankB;
            arr[i] = numB;
            arr[rankB] = numA;
            aResult++;
        }
    }
    
    //Descending sort
    var bResult = 0;
    var desortedArr = mixedArray.slice().reverse();
    var indexBrr = [];
    
    for (var i=0; i<brr.length; i++) {
        indexBrr[brr[i]] = i;
    }

    for (var i=0; i<desortedArr.length; i++) {
        if (desortedArr[i] != brr[i]) {
            var numA = brr[i];
            var numB = desortedArr[i];
            var rankB = indexBrr[desortedArr[i]];
            indexBrr[desortedArr[i]] = i;
            indexBrr[brr[i]] = rankB;
            brr[i] = numB;
            brr[rankB] = numA;
            bResult++;
        }
    }
    
    return Math.min(aResult, bResult);

}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const n = parseInt(readLine(), 10);

    const arr = readLine().split(' ').map(arrTemp => parseInt(arrTemp, 10));

    let result = lilysHomework(arr);

    ws.write(result + "\n");

    ws.end();
}
