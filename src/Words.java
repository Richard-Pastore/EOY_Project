
public class Words {
private String[] wordList;
private String answer, DisplayWord;
public Words() {
	wordList=new String[177];
	wordList[0]="Dolphin";
	wordList[1]="Shark";
	wordList[2]="Whale";
	wordList[3]="Octopus";
	wordList[4]="Seal";
	wordList[5]="Jellyfish";
	wordList[6]="Starfish";
	wordList[7]="Squid";
	wordList[8]="Turtle";
	wordList[9]="Crab";
	wordList[10]="Lobster";
	wordList[11]="Seahorse";
	wordList[12]="Clownfish";
	wordList[13]="Eel";
	wordList[14]="Manatee";
	wordList[15]="Anemone";
	wordList[16]="Seagull";
	wordList[17]="Stingray";
	wordList[18]="Swordfish";
	wordList[19]="Pufferfish";
	wordList[20]="Orca";
	wordList[21]="Seahorse";
	wordList[22]="Walrus";
	wordList[23]="Dugong";
	wordList[24]="Beluga";
	wordList[25]="Oyster";
	wordList[26]="Manta";
	wordList[27]="Barracuda";
	wordList[28]="Marlin";
	wordList[29]="Tuna";
	wordList[30]="Narwhal";
	wordList[31]="Dolphin";
	wordList[32]="Shark";
	wordList[33]="Whale";
	wordList[34]="Octopus";
	wordList[35]="Seal";
	wordList[36]="Jellyfish";
	wordList[37]="Starfish";
	wordList[38]="Squid";
	wordList[39]="Turtle";
	wordList[40]="Crab";
	wordList[41]="Lobster";
	wordList[42]="Seahorse";
	wordList[43]="Clownfish";
	wordList[44]="Eel";
	wordList[45]="Manatee";
	wordList[46]="Anemone";
	wordList[47]="Seagull";
	wordList[48]="Stingray";
	wordList[49]="Swordfish";
	wordList[50]="Pufferfish";
	wordList[51]="Orca";
	wordList[52]="Seahorse";
	wordList[53]="Walrus";
	wordList[54]="Dugong";
	wordList[55]="Beluga";
	wordList[56]="Oyster";
	wordList[57]="Manta";
	wordList[58]="Barracuda";
	wordList[59]="Marlin";
	wordList[60]="Tuna";
	wordList[61]="Narwhal";
	wordList[62]="Dolphin";
	wordList[63]="Shark";
	wordList[64]="Whale";
	wordList[65]="Octopus";
	wordList[66]="Seal";
	wordList[67]="Jellyfish";
	wordList[68]="Starfish";
	wordList[69]="Squid";
	wordList[70]="Turtle";
	wordList[71]="Crab";
	wordList[72]="Lobster";
	wordList[73]="Seahorse";
	wordList[74]="Clownfish";
	wordList[75]="Eel";
	wordList[76]="Manatee";
	wordList[77]="Anemone";
	wordList[78]="Seagull";
	wordList[79]="Stingray";
	wordList[80]="Swordfish";
	wordList[81]="Pufferfish";
	wordList[82]="Orca";
	wordList[83]="Seahorse";
	wordList[84]="Walrus";
	wordList[85]="Dugong";
	wordList[86]="Beluga";
	wordList[87]="Oyster";
	wordList[88]="Manta";
	wordList[89]="Barracuda";
	wordList[90]="Marlin";
	wordList[91]="Tuna";
	wordList[92]="Narwhal";
	wordList[93]="Dolphin";
	wordList[94]="Shark";
	wordList[95]="Whale";
	wordList[96]="Octopus";
	wordList[97]="Seal";
	wordList[98]="Jellyfish";
	wordList[99]="Starfish";
	wordList[100]="Squid";
	wordList[101]="Turtle";
	wordList[102]="Crab";
	wordList[103]="Lobster";
	wordList[104]="Seahorse";
	wordList[105]="Clownfish";
	wordList[106]="Eel";
	wordList[107]="Manatee";
	wordList[108]="Anemone";
	wordList[109]="Seagull";
	wordList[110]="Stingray";
	wordList[111]="Swordfish";
	wordList[112]="Pufferfish";
	wordList[113]="Orca";
	wordList[114]="Seahorse";
	wordList[115]="Walrus";
	wordList[116]="Dugong";
	wordList[117]="Beluga";
	wordList[118]="Oyster";
	wordList[119]="Manta";
	wordList[120]="Barracuda";
	wordList[121]="Marlin";
	wordList[122]="Tuna";
	wordList[123]="Narwhal";
	wordList[124]="Dolphin";
	wordList[125]="Shark";
	wordList[126]="Whale";
	wordList[127]="Octopus";
	wordList[128]="Seal";
	wordList[129]="Jellyfish";
	wordList[130]="Starfish";
	wordList[131]="Squid";
	wordList[132]="Turtle";
	wordList[133]="Crab";
	wordList[134]="Lobster";
	wordList[135]="Seahorse";
	wordList[136]="Clownfish";
	wordList[137]="Eel";
	wordList[138]="Manatee";
	wordList[139]="Anemone";
	wordList[140]="Seagull";
	wordList[141]="Stingray";
	wordList[142]="Swordfish";
	wordList[143]="Pufferfish";
	wordList[144]="Orca";
	wordList[145]="Seahorse";
	wordList[146]="Walrus";
	wordList[147]="Dugong";
	wordList[148]="Beluga";
	wordList[149]="Oyster";
	wordList[150]="Manta";
	wordList[151]="Barracuda";
	wordList[152]="Marlin";
	wordList[153]="Tuna";
	wordList[154]="Narwhal";
	wordList[155]="Dolphin";
	wordList[156]="Shark";
	wordList[157]="Whale";
	wordList[158]="Octopus";
	wordList[159]="Seal";
	wordList[160]="Jellyfish";
	wordList[161]="Starfish";
	wordList[162]="Squid";
	wordList[163]="Turtle";
	wordList[164]="Crab";
	wordList[165]="Lobster";
	wordList[166]="Seahorse";
	wordList[167]="Clownfish";
	wordList[168]="Eel";
	wordList[169]="Manatee";
	wordList[170]="Anemone";
	wordList[171]="Seagull";
	wordList[172]="Stingray";
	wordList[173]="Swordfish";
	wordList[174]="Pufferfish";
	wordList[175]="Orca";
	wordList[176]="Seahorse";

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
