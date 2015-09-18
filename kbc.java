import java.util.*;
interface Quiz{	
	void addQuestion(Question q);
	Participant registerParticipant(String name, int age, String phone);
	int getCurrentLevel();
	Question getNextQuestion();
	boolean lockAnswer(Question q, String answer);
	int getPrizeMoney();
}

class Question{
	protected String question;
	protected int level;
	protected String correctAnswer; 
	Question(String question,int level,String correctAnswer){
		this.question=question;
		this.level=level;
		this.correctAnswer=correctAnswer;
	}	
	public String getQuestion(){
		return question;
	}
	public int getLevel(){
		return level;
	}
	public String getCorrectAnswer(){
		return correctAnswer;
	}
}
class Participant{
	Participant(String name,int age,String phone){
		this.name=name;
		this.age=age;
		this.phone=phone;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
	public String getPhone(){
		return phone;
	}
	private String name;
	private int age;
	private String phone;
	private int currentLevel;
	private int prizeMoney;	
}
public class kbc implements Quiz{
	static String s;
	static ArrayList<Question> al=new ArrayList<Question>();
	public void addQuestion(Question q){
		al.add(q);
	}
	public static void printList(){
		for(Question q:al)
		System.out.println(q.question+" : "+q.level+":"+q.correctAnswer);
	}
	public Participant registerParticipant(String name, int age, String phone){	
		Participant p=new Participant(name,age,phone);
		return p;
	}
	public int getCurrentLevel(){
		return al.size();
	}
	public Question getNextQuestion(){
		return al.get(al.size()-1);
		
	}
	public boolean lockAnswer(Question q, String answer){
		s=answer;
		if(q.correctAnswer.equals(answer)){
			return true;
		}
		return false;

	}
	public int getPrizeMoney(){
		if(al.size()==2){
	    return 1000;
        }
        else if(al.size()==3){
        	return 2000;
        }
        else if(al.size()==4){
        	return 3000;
        }
        else if(al.size()==5){
        	return 5000;
        }
        else if(al.size()==6){
        	return 10000;
        }
        else if(al.size()==7){
        	return 20000;
        }
        else if(al.size()==8){
        	return 40000;
        }
        else if(al.size()==9){
        	return 80000;
        }
        else if(al.size()==10){
        	return 160000;
        }
        else if(al.size()==11){
        	return 320000;
        }
        else if(al.size()==12){
        	return 640000;
        }
        else if(al.size()==13){
        	return 1250000;
        }
        else if(al.size()==14){
        	return 2500000;
        }
        else if(al.size()==15){
        	  
        	return 5000000;
        }
        else if(al.size()==1){
        	return 0;
        }
       
        	return 10000000;
	}
	public static void main(String[] args){
		kbc kbc=new kbc();
		Participant p=kbc.registerParticipant("harika",22,"9848186271");
		System.out.println("Name:::"+p.getName()+"\nAge::::"+p.getAge()+"\nphone::"+p.getPhone());

		for(int i=1;i<=15;i++){
		kbc.addQuestion(new Question("question "+i,i,"A"));
		System.out.println("Start play the game");
		Question q=kbc.getNextQuestion();
		System.out.println("Your Question is:"+q.question);
		System.out.println("Options are:A\t B\t C\t D");
		System.out.println("Enter Your option");
		Scanner scan=new Scanner(System.in);
		String s=scan.next();
		if(s.equals("quit")){
			int k=kbc.getPrizeMoney();
			System.out.println("You won:"+k);
			break;
		}
		boolean b=kbc.lockAnswer(al.get(al.size()-1),s);
		if(b==false){
			if(al.size()<=5){
				System.out.println("You won RS.0 !!!Better Luck Next Time");
			}else if(al.size()>5 && al.size()<=10){
				System.out.println("You won RS.10000 only");
			}else if(al.size()>10 && al.size()<=15){
				System.out.println("You won RS.320000 only");
			}
			break;
		}else{
			if(al.size()==15){
				System.out.println("You won RS.10000000 and you won the show");
			}
		}

	    }
	    System.out.println("You are at level "+kbc.getCurrentLevel());	 
}
}
