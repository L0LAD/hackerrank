{-# LANGUAGE FlexibleInstances, UndecidableInstances, DuplicateRecordFields #-}

module Main where

import Control.Monad
import Data.Array
import Data.Bits
import Data.List
import Data.List.Split
import Debug.Trace
import System.Environment
import System.IO
import System.IO.Unsafe

-- Complete the plusMinus function below.
plusMinus arr = unlines (map show [p, n, z])
                        where p = getRatio (filter (>0) arr) arr
                              n = getRatio (filter (<0) arr) arr
                              z = getRatio (filter (==0) arr) arr

getRatio l1 l2 = fromIntegral (length l1) / fromIntegral (length l2)

readMultipleLinesAsStringArray :: Int -> IO [String]
readMultipleLinesAsStringArray 0 = return []
readMultipleLinesAsStringArray n = do
    line <- getLine
    rest <- readMultipleLinesAsStringArray(n - 1)
    return (line : rest)

parse :: String -> Int
parse = read 

main :: IO()
main = interact $ plusMinus . map parse . words . last . lines
