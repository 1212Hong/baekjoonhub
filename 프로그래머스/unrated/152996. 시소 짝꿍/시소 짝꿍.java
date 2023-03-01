import java.util.*;

class Solution {


	public long solution(int[] weights) {

		Map<Double, Integer> map = new HashMap<Double, Integer>();
		long answer = 0;

		Arrays.sort(weights);
		
		for (int weight : weights) {
			answer += solution(weight, map);
		}
        return answer;

	}

	private static long solution(int weight, Map<Double, Integer> map) {
		long count = 0;
		double t1 = weight * 1.0;
		double t2 = (weight * 1.0) / 2.0;
		double t3 = (weight * 2.0) / 3.0;
		double t4 = (weight * 3.0) / 4.0;

		if (map.containsKey(t1))
			count += map.get(t1);
		if (map.containsKey(t2))
			count += map.get(t2);
		if (map.containsKey(t3))
			count += map.get(t3);
		if (map.containsKey(t4))
			count += map.get(t4);
		map.put(weight * 1.0, map.getOrDefault(weight * 1.0, 0) + 1);
		return count;
	}

}