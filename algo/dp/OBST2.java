package com.algo.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class OBST2 {
	int min = Integer.MAX_VALUE;
	List<Element> elementList = new ArrayList<>();
	int[][][] dp;

	private int binaryTree(int[] nodes, int[] freq) {
		dp = new int[nodes.length][nodes.length][nodes.length];
		for (int i = 0; i < nodes.length; i++) {
			elementList.add(new Element(nodes[i], freq[i]));
		}
		elementList.sort((a, b) -> a.val - b.val);
		return binaryTree(0, nodes.length - 1, 1);
	}

	private int binaryTree(int left, int right, int level) {
		if (left > right) return 0;
		if (left == right) {
			return level * elementList.get(left).freq;
		}
		if (dp[left][right][level] != 0) {
			return dp[left][right][level];
		}
		int min = Integer.MAX_VALUE;
		for (int mid = left; mid <= right; mid++) {
			int leftValue = binaryTree(left, mid - 1, level + 1);
			int rightValue = binaryTree(mid + 1, right, level + 1);
			min = Math.min(min, (elementList.get(mid).freq * level) + leftValue + rightValue);
		}
		return dp[left][right][level] = min;
	}
}

class Element {
	int val;
	int freq;

	public Element(int node, int i) {
		val = node;
		freq = i;
	}
}
