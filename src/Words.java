
public class Words {
private String[] wordList;
private String answer, DisplayWord;
public Words() {
	wordList=new String[30];
	wordList[0]="Kuala Lumpur";
	wordList[1]="Bern";
	wordList[2]="Helsinki";
	wordList[3]="Beijing";
	wordList[4]="Kathmandu";
	wordList[5]="Brussels";
	wordList[6]="Berlin";
	wordList[7]="Paris";
	wordList[8]="Prague";
	wordList[9]="Rome";
	wordList[10]="Mexico City";
	wordList[11]="San Salvador";
	wordList[12]="Manila";
	wordList[13]="London";
	wordList[14]="Madrid";
	wordList[15]="Warsaw";
	wordList[16]="Moscow";
	wordList[17]="Wellington";
	wordList[18]="Ottawa";
	wordList[19]="Pyongyang";
	wordList[20]="Jakarta";
	wordList[21]="Bucharest";
	wordList[22]="Rabat";
	wordList[23]="Vienna";
	wordList[24]="Oslo";
	wordList[25]="San Jose";
	wordList[26]="Santiago";
	wordList[27]="Quito";
	wordList[28]="Lima";
	wordList[29]="Brasilia";

	   //need to keep this after   the array is set up
    answer = getRandomWord();
    DisplayWord= setDisplayWord();
    System.out.println(answer);
    System.out.println(getRandomNumber());
	System.out.println(DisplayWord);
}

public int getRandomNumber() {
    return (int)(Math.random()*(wordList.length-1-0))+0 +1;
}

public String getRandomWord() {
    return wordList[getRandomNumber()];
}


private String setDisplayWord() {
//TODO Auto-generated method stub
String s="";

//set dashes
for (int i=0; i<answer.length(); i++) {
if(answer.charAt(i)==' ') {
s+=" ";
}
else {
s+="-";
}

}

	
return s;
}

public String getDisplayWord() {
 return DisplayWord;

  
}

public boolean checkGuess (char c) {
 boolean correct=false;
 for(int i=0; i<answer.length(); i++) {
	 

	if(Character.toLowerCase(answer.charAt(i))==c) {
	
	 correct=true;
	 DisplayWord = DisplayWord.substring(0,i) + c + DisplayWord.substring (i+1);
	}
 }
 return correct;
}
 
 



public void reset() {
 answer=getRandomWord();
 System.out.println(answer);
 DisplayWord= setDisplayWord();
 
}

public String getAnswer() {
// TODO Auto-generated method stub
return null;
}
}
