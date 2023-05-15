package card_11652;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;	

public class Main {
	
	/*
	 * 준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -2^62보다 크거나 같고, 2^62보다 작거나 같다. 
	 * (-262<<262 가 아니었음)
	 * 준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 
	 * 만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
	 * 
	 * 첫째 줄에 준규가 가지고 있는 숫자 카드의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 
	 * 둘째 줄부터 N개 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
	 * 
	 * 첫째 줄에 준규가 가장 많이 가지고 있는 정수를 출력한다.
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = 0;
		
		List<Long> list = new ArrayList<>(N);
		Map<Long,Integer> map = new HashMap<>(N);
		
		
		for(int i=0; i<N; i++) {
			long a = sc.nextLong();
			
			if(map.containsKey(a)) {
				map.put(a, map.get(a)+1);
			}else {
				map.put(a, 1);
			}
			
			if(map.get(a)>M) {
				M = map.get(a);
				list.clear();
				list.add(a);
			}else if(map.get(a)==M) {
				list.add(a);
			}
			
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(0));
		
		
		sc.close();
	}

}