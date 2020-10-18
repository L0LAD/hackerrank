module Main where

-- Complete this function
gcd' :: Integral a => a -> a -> a
gcd' n m | m `mod` n == 0 = n
         | n `mod` m == 0 = m
         | otherwise = gcd' a b where a = (max n m) - (min n m)
                                      b = min n m


-- This part is related to the Input/Output and can be used as it is
-- Do not modify it
main = do
  input <- getLine
  print . uncurry gcd' . listToTuple . convertToInt . words $ input
 where
  listToTuple (x:xs:_) = (x,xs)
  convertToInt = map (read :: String -> Int)