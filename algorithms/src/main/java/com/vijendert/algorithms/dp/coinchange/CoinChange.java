package com.vijendert.algorithms.dp.coinchange;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange rcc = new CoinChange();
		int[] coinValue = {1,2,3};
		int res = rcc.naiveCoinChange(4, coinValue, 0);
		System.out.println(res);
		rcc.dpProgrammingCoinChange(4, coinValue);
	}
	
	public int naiveCoinChange(int M,int[] v,int index)
	{
		if(M < 0) return 0;
		if(M == 0) return 1;
		
		if(v.length == index) return 0;
		return naiveCoinChange(M-v[index], v, index) + naiveCoinChange(M, v, index+1);
	}
	
	public void dpProgrammingCoinChange(int M,int[] v)
	{
		//first create the matrix and fill it 
		int[][] dpTable = new int[v.length+1][M+1];
		for(int i = 0;i < M+1;i++)
		{
			dpTable[0][i] = 0;
		}
		
		for(int i = 0 ; i < v.length+1;i++)
		{
			dpTable[i][0] = 1;
		}
		
		for(int i = 1;i < v.length+1;i++)
		{
			for(int j = 1;j<M+1;j++)
			{
				if(v[i-1] <= j)
				{
					dpTable[i][j] = dpTable[i-1][j] + dpTable[i][j-v[i-1]];
				}
				if(v[i-1] > j)
				{
					dpTable[i][j] = dpTable[i-1][j];
				}
			}
		}
		
		System.out.println("The answer is : "+dpTable[v.length][M]);
	}

}
