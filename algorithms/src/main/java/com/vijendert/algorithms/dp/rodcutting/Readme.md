I wrote a naive kind of recursive program
for the rod cutting problem

My approach was 

Given the length of the  rod 5
Prices at each cut * 
Please note a 5 m rod can have len-1 cuts
cut at 1m, 2m ,3m, 4m
Prices array is {2,5,7,3} at each cut

So in my function I assume

lenght 5 first cut length

5-1 = 4   sum = sum + price[i-1] i being 1 2
4-1 = 3   sum = sum + price[i-1] i being 1 4
3-1 = 2   sum = sum + price[i-1] i being 1 6
2-1 = 1   sum = sum + price[i-1] i being 1 8
1-1 = 0   sum = sum + price[i-1] i being 1 10

Now we pick the other one

5-2 = 3  sum = sum + price[i-1] i being 2 5
3-2 = 1  sum = sum + price[i-1] i being 2 10
1-2 = -1
 If -ve don't do the sum. Hold it
return to orginal value
1+2 = 1
Subtract the index 2 by 1 so it becomes 2-1 = 1
Here I run a while loop which is wrong piece of code I need to correct it but it works

So now I caculate sum and the index
1-1 = 0

