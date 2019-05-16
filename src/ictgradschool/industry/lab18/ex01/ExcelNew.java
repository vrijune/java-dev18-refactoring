package ictgradschool.industry.lab18.ex01;

import java.io.*;
import java.util.*;

/**
 * TODO Please test & refactor this - my eyes are watering just looking at it :'(
 */
public class ExcelNew {

	public static void main(String [] args){
		String line;
		String output;
		int classSize;
		ArrayList<String> firstNameList = new ArrayList<String>();
		ArrayList<String> surnameList = new ArrayList<String>();
		try{
			BufferedReader br = new BufferedReader(new FileReader("FirstNames.txt"));
			while((line = br.readLine())!= null){
				firstNameList.add(line);
			}
			br.close();
			br = new BufferedReader(new FileReader("Surnames.txt"));
			while((line = br.readLine())!= null){
				surnameList.add(line);
			}
			br.close();
			classSize = 550;
			output="";
			for(int i = 1; i <= classSize; i++){
				String student = "";
				if(i/10 < 1){
					student += "000" + i;
				}else if (i/100 < 1){
					student += "00" + i;
				}else if (i/1000 < 1){
					student += "0"+i;
				}else{
					student += i;
				}
				int randFNIndex = (int)(Math.random()*firstNameList.size());
				int randSNIndex = (int)(Math.random()*surnameList.size());
				student += "\t" + surnameList.get(randSNIndex) + "\t" + firstNameList.get(randFNIndex) + "\t";
				//Student Skill
				int randStudentSkill = (int)(Math.random()*101);
				//Labs//////////////////////////
				int numLabs = 3;
				for(int j = 0; j < numLabs; j++){
					if(randStudentSkill <= 5){
						student += (int)(Math.random()*40); //[0,39]
					}else if ((randStudentSkill > 5) && (randStudentSkill <= 15)){
						student += ((int)(Math.random()*10) + 40); // [40,49]
					}else if((randStudentSkill > 15) && (randStudentSkill <= 25)){
						student += ((int)(Math.random()*20) + 50); // [50,69]
					}else if((randStudentSkill > 25) && (randStudentSkill <= 65)){
						student += ((int)(Math.random()*20) + 70); // [70,89]
					} else{
						student += ((int)(Math.random()*11) + 90); //[90,100]
					}
					student += "\t";
				}
				//Test/////////////////////////
				if(randStudentSkill <= 5){
					student += (int)(Math.random()*40); //[0,39]
				}else if((randStudentSkill > 5) && (randStudentSkill <= 20)){
						student += ((int)(Math.random()*10) + 40); //[40,49]
				} else if((randStudentSkill > 20) && (randStudentSkill <= 65)){
					student += ((int)(Math.random()*20) + 50); //[50,69]
				} else if((randStudentSkill > 65) && (randStudentSkill <= 90)){
					student += ((int)(Math.random()*20) + 70); //[70,89]
				} else{
					student += ((int)(Math.random()*11) + 90); //[90,100]
				}
				student += "\t";
				///////////////Exam////////////
				if(randStudentSkill <= 7){
					int randDNSProb = (int)(Math.random()*101);
					if(randDNSProb <= 5){
						student += ""; //DNS
					}else{
						student += (int)(Math.random()*40); //[0,39]
					}
				} else if((randStudentSkill > 7) && (randStudentSkill <= 20)){
						student += ((int)(Math.random()*10) + 40); //[40,49]
				} else if((randStudentSkill > 20) && (randStudentSkill <= 60)){
					student += ((int)(Math.random()*20) + 50);//[50,69]
				} else if((randStudentSkill > 60) && (randStudentSkill <= 90)){
					student += ((int)(Math.random()*20) + 70); //[70,89]
				} else{
					student += ((int)(Math.random()*11) + 90); //[90,100]
				}
				//////////////////////////////////
				student += "\n";
				output += student;
			}
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("Data_Out.txt"));
			bw.write(output);
			bw.close();
		}
		catch(IOException e){
			System.out.println(e);
		}
	}

}