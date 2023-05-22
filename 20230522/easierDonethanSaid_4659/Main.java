package easierDonethanSaid_4659;

import java.util.*;

/*
 * 좋은 패스워드를 만드는것은 어려운 일이다. 대부분의 사용자들은 buddy처럼 발음하기 좋고 기억하기 쉬운 패스워드를 원하나, 이런 패스워드들은 보안의 문제가 발생한다. 
 * 어떤 사이트들은 xvtpzyo 같은 비밀번호를 무작위로 부여해 주기도 하지만, 사용자들은 이를 외우는데 어려움을 느끼고 심지어는 포스트잇에 적어 컴퓨터에 붙여놓는다. 
 * 가장 이상적인 해결법은 '발음이 가능한' 패스워드를 만드는 것으로 적당히 외우기 쉬우면서도 안전하게 계정을 지킬 수 있다. 
 * 
 * 높은 품질을 가진 비밀번호의 조건은 다음과 같다.
 * 
 * 1.모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
 * 2.모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
 * 3.같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
 * 
 * 입력은 여러개의 테스트 케이스로 이루어져 있다.
 * 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 테스트할 패스워드가 주어진다.
 * 마지막 테스트 케이스는 end이며, 패스워드는 한글자 이상 20글자 이하의 문자열이다. 또한 패스워드는 대문자를 포함하지 않는다.
 * 
 * 각 테스트 케이스를 '예제 출력'의 형태에 기반하여 품질을 평가하여라.
 * >> <keyword> is acceptable. / is not acceptable.
 */

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Set<String> set = new HashSet<>(5);
		set.add("a");
		set.add("e");
		set.add("i");
		set.add("o");
		set.add("u");
		
		while(true) {
			String str = sc.next();
			if(str.equals("end")) {
				break;
			}
			
			//a자음 b모음 vowel 모음사용개수
			int fail = 0;//0성공 1실패
			int a = 0; 
			int b = 0;
			int vowel = 0;
			
			//직전 문자
			String last = "";
			String[] arr = str.split("");
			
			for(int i=0; i<arr.length; i++) {
				String now = arr[i];
				//지난 문자랑 같은데 e나 o가 아니야 > 실패
				if(last.equals(now) && !now.equals("e") & !now.equals("o")) {
					fail = 1;
					break;
				}
				
				//모음이야
				if(set.contains(now)) {
					//근데 이미 이전 모음 두개 씀
					if(b>=2) {
						fail = 1;
						break;
					}
					//두개 안씀 자음 0 모음 ++
					a=0;
					b++;
					vowel++;
					
					//자음이야
				}else {
					//자음 두번?
					if(a>=2) {
						fail = 1;
						break;
					}
					
					a++;
					b=0;
				}
				
				last = now;
			}
			
			if(fail==0 && vowel>0) {
				System.out.println("<"+str+"> is acceptable.");
			}else {
				System.out.println("<"+str+"> is not acceptable.");
			}
			
		}
		
		sc.close();
		
	}
}