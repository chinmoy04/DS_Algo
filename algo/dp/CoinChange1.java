package com.algo.dp;


import java.text.Format;
import java.util.HashMap;
import java.util.Map;

/**
 * Date 08/12/2013
 * @author Tushar Roy
 *
 * Given a total and coins of certain denomination with infinite supply, what is the minimum number
 * of coins it takes to form this total.
 *
 * Time complexity - O(coins.size * total)
 * Space complexity - O(coins.size * total)
 *
 * Youtube video -
 * Topdown DP - https://youtu.be/Kf_M7RdHr1M
 * Bottom up DP - https://youtu.be/Y0ZqKpToTic
 */
public class CoinChange1 {

	/**
	 * Top down dynamic programing. Using map to store intermediate results.
	 * Returns Integer.MAX_VALUE if total cannot be formed with given coins
	 */
	public int minimumCoinTopDown(int total, int coins[], Map<Integer, Integer> map) {

		//if total is 0 then there is nothing to do. return 0.
		if ( total == 0 ) {
			return 0;
		}

		//if map contains the result means we calculated it before. Lets return that value.
		if ( map.containsKey(total) ) {
			return map.get(total);
		}

		//iterate through all coins and see which one gives best result.
		int min = Integer.MAX_VALUE;
		for ( int i=0; i < coins.length; i++ ) {
			//if value of coin is greater than total we are looking for just continue.
			if( coins[i] > total ) {
				continue;
			}
			//recurse with total - coins[i] as new total
			int val = minimumCoinTopDown(total - coins[i], coins, map);

			//if val we get from picking coins[i] as first coin for current total is less
			// than value found so far make it minimum.
			if( val < min ) {
				min = val;
			}
		}

		//if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to it.
		min =  (min == Integer.MAX_VALUE ? min : min + 1);

		//memoize the minimum for current total.
		map.put(total, min);
		return min;
	}

	/**
	 * Bottom up way of solving this problem.
	 * Keep input sorted. Otherwise temp[j-arr[i]) + 1 can become Integer.Max_value + 1 which
	 * can be very low negative number
	 * Returns Integer.MAX_VALUE - 1 if solution is not possible.
	 */
	public int minimumCoinBottomUp(int total, int coins[]){
		int no_of_coins[] = new int[total + 1];
		int index_of_denomination[] = new int[total + 1];
		no_of_coins[0] = 0;
		
		for(int i=1; i <= total; i++){
			no_of_coins[i] = Integer.MAX_VALUE-1;
			index_of_denomination[i] = -1;
		}
		
		for(int j=0; j < coins.length; j++){
			for(int i=1; i <= total; i++){
				if(i >= coins[j]){
					if (no_of_coins[i - coins[j]] + 1 < no_of_coins[i]) {
						no_of_coins[i] = 1 + no_of_coins[i - coins[j]];
						index_of_denomination[i] = j;
					}
				}
			}
		}
		
		printCoinCombination(index_of_denomination, coins);
		return no_of_coins[total];
	}

	private void printCoinCombination(int R[], int coins[]) {
		if (R[R.length - 1] == -1) {
			System.out.print("No solution is possible");
			return;
		}
		int start = R.length - 1;
		System.out.print("Coins used to form total ");
		while ( start != 0 ) {
			int j = R[start];
			System.out.print(coins[j] + " ");
			start = start - coins[j];
		}
		System.out.print("\n");
	}

	public static void main ( String args[] ) {
		int total = 13;
		int coins[] = {7, 3, 2, 6};
		CoinChange1 cc = new CoinChange1();
		Map<Integer, Integer> map = new HashMap<>();
		int topDownValue = cc.minimumCoinTopDown(total, coins, map);
		int bottomUpValue = cc.minimumCoinBottomUp(total, coins);

		System.out.print(String.format("Bottom up and top down result %s %s", bottomUpValue, topDownValue));

	}
}