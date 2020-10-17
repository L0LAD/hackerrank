{-# LANGUAGE FlexibleInstances, UndecidableInstances, DuplicateRecordFields #-}

module Main where

import Control.Monad
import Data.Array
import Data.Bits
import Data.List
import Data.List.Split
import Data.Set
import Debug.Trace
import System.Environment
import System.IO
import System.IO.Unsafe

miniMaxSum :: [Int] -> String
miniMaxSum l = show min ++ " " ++ show max
  where min = sum $ init $ sort l
        max = sum $ tail $ sort l

parse :: String -> [Int]
parse input = Data.List.map read $ words input :: [Int]

main :: IO()
main = do
  input <- getLine
  putStrLn $ miniMaxSum $ parse input