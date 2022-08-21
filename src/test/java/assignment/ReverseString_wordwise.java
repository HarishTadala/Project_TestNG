package assignment;

import java.util.Scanner;

public class ReverseString_wordwise {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Original String :");
	String originalstrg=sc.nextLine();
	sc.close();
	
	String words[]=originalstrg.split("\\s");
	String reverseString="";
	
	for(int i=0;i<words.length;i++)
	{
		String word=words[i];
		String reverseword="";
		
		for(int j=word.length()-1;j>=0;j--)
		{
			reverseword=reverseword+word.charAt(j);
		}
		reverseString=reverseString+reverseword+" ";
	}
	System.out.println(reverseString);

	}
	}