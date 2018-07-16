package cn.hnust;

import java.util.ArrayList;
import java.util.Random;

public class Question {

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getquestion() {
		return question;
	}

	public void setquestion(String question) {
		this.question = question;
	}

	public String getoptA() {
		return optA;
	}

	public void setoptA(String optA) {
		this.optA = optA;
	}

	public String getoptB() {
		return optB;
	}

	public void setoptB(String optB) {
		this.optB = optB;
	}

	public String getoptC() {
		return optC;
	}

	public void setoptC(String optC) {
		this.optC = optC;
	}
	
	public String getoptD() {
		return optD;
	}

	public void setoptD(String optD) {
		this.optD = optD;
	}
	public String getanswer() {
		return answer;
	}

	public void setanswer(String answer) {
		this.answer = answer;
	}
	public String id;
	public String question;
	public String optA;
	public String optB;
	public String optC;
	public String optD;
	public String answer;
	
	public Question() {
		
	}
	public Question(String id, 
			String question, String optA, 
			String optB, String optC,String optD,String answer) {
		this.id = id;
		this.question = question;
		this.optA = optA;
		this.optB = optB;
		this.optC = optC;
		this.optD = optD;
		this.answer =answer;
	}
	public static void main(String[] args) {
		Question s1=new Question("1","1+1","0","1","2","3","C");
		Question s2=new Question("2","2+2","1","2","3","4","D");
		Question s3=new Question("3","3+3","3","4","5","6","D");
		Question s4=new Question("4","4+4","4","6","8","10","C");
		
		ArrayList<Question> List =new ArrayList<Question>();
		List.add(s1);
		List.add(s2);
		List.add(s3);
		List.add(s4);
		
		for(int i=0;i<List.size();i++){
			Question s =List.get(i);
			System.out.println(s.id+" "+s.question+" "
					+s.optA+" "
					+s.optB+" "
					+s.optC+" "
					+s.optD+" "
					+s.answer);
		}
		int N=10;
		int[] g={-1,-1,-1,-1};
		Random r=new Random();
		int j=0;
		while(j<4){
			int num=r.nextInt(N);
			int k=0;
			while(k<4){
				if(g[k]==num)
					break;
				k++;
			}
			if(k==4){
				g[j]=num;
				j++;
				System.out.println(num);
			}
		}

	}

}
