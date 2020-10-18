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

helloWorlds 0 = return ()
helloWorlds n = do
                   putStrLn "Hello World"
                   helloWorlds $ n-1


main :: IO()
main = do
    n <- readLn :: IO Int

    -- Print "Hello World" on a new line 'n' times.
    helloWorlds n
