<?php

/*
 * Complete the timeConversion function below.
 */
function timeConversion($s) {
    $time = strtotime($s);
    return date('H:i:s', $time);
}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$__fp = fopen("php://stdin", "r");

fscanf($__fp, "%[^\n]", $s);

$result = timeConversion($s);

fwrite($fptr, $result . "\n");

fclose($__fp);
fclose($fptr);
