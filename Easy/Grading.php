<?php

/*
 * Complete the 'gradingStudents' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY grades as parameter.
 */

function gradingStudents($grades) {
    $result = [];
    foreach ($grades as $grade) {
        $nextFive = $grade + (5 - $grade % 5);
        $diff = $nextFive - $grade;
        if ($grade > 37 && $diff < 3) {
            $grade = $nextFive;
        }
        array_push($result, $grade);
    }
    return $result;
}

$fptr = fopen(getenv("OUTPUT_PATH"), "w");

$grades_count = intval(trim(fgets(STDIN)));

$grades = array();

for ($i = 0; $i < $grades_count; $i++) {
    $grades_item = intval(trim(fgets(STDIN)));
    $grades[] = $grades_item;
}

$result = gradingStudents($grades);

fwrite($fptr, implode("\n", $result) . "\n");

fclose($fptr);
