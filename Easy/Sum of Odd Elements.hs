-- Fill up this function body
f [] = 0
f (x:xs) | odd x == True = x + f xs
         | otherwise = f xs



-- This part handles the Input/Output and can be used as it is. Do not change or modify it.
main = do
	inputdata <- getContents
	putStrLn $ show $ f $ map (read :: String -> Int) $ lines inputdata