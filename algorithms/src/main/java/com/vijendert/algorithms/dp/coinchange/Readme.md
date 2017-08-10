1. There is a naive approach where we take each coin
keep subtracting from the total till we get the sum as zero.

2. Example 

Sum of 4
coins we have is 1,2,3

We pick 1 , keep subtracting from 4 so we end up with 4 coins of 1 each.
then we pick 2, subtract it from 4 we get 2 and then we can pick another coin of 
2 and stop.
But here we have another case where where after picking a coin of 2 we can the remaining 2 from two 1 coins.
So in short we go back and keep seeing for the sum is zero.

The problem with approach is that we have two choices for a coin pick or reject.
There are n coins so our result becomes 2^n

So in DP solution the row number represent the coin number not the value
It is more like saying if u use 1 coin u will be able to attain sum of 0,1,2,3,4
in 1 way each
the sum is presented in the form of the column
Rest is all ok the point to remember is very important
What are we achieving with doing j-v[i-1] where j is column meaning the sum
and i is the row . The point here is we can attain the sum 4 using single coin in the single way 1111
We can attain the sum 4 using two coins so here we know how to attain the sum using single coin the only thing that is left is using the new coin value. So if we use the j-v[i-1] we are looking at the value which will involve that particular coin in the pattern

----------------------VERY IMPORTANT----------------------------
This is the main gist of the coin problem


For attaining the sum of 4 we do j-v[i-1]
which results in the value [2],[2]
so we can make a statement out of it which states how many ways are there to attain the sum of 2 using 2 coins. Our answer will be 2 ways.

So since we subracted the value 2 from 4 to reach the value

the ways over there, all we need to add is the 2 in it to make the result as 4
