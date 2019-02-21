import java.lang.*;
import java.io.*;
import java.util.Scanner;
public class MyFileIO
{
	public static void main(String []args) throws Exception
	{
		int alpha=0,vow=0,cons=0,word=0,sent=0,line=0,i;
		Scanner sc = new Scanner(System.in);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(isr);
		
		String s="", temp; 
		char choice = 'y';
		
		File file1 = new File("input.txt");
		  
		file1.createNewFile();
		
		FileWriter writer1 = new FileWriter(file1); 
		  
		while(choice=='y')
		{
			line++;
			temp = bfr.readLine();
			s=s+temp+"\r"+"\n";
			System.out.println("More? y for yes and n for no");
			choice=sc.next().charAt(0); 
		}
		writer1.write(s); 
		writer1.flush();
		writer1.close();
		
		FileReader reader=new FileReader(file1);
		String a="";
		BufferedReader bfl=new BufferedReader(reader);
		while((temp=bfl.readLine())!=null)
		{
			a=a+temp+"\n"+"\r";
		}
		//System.out.println(a);
		reader.close();
		
		for(i=0;i<a.length();i++)
		{
			if((a.charAt(i)>=65 && a.charAt(i)<=90) || (a.charAt(i)>=97 && a.charAt(i)<=121))
			{
				alpha++;
			}
			if(a.charAt(i)=='A' || a.charAt(i)=='E' || a.charAt(i)=='I' || a.charAt(i)=='O' || a.charAt(i)=='U' || a.charAt(i)=='a' || a.charAt(i)=='e' || a.charAt(i)=='i' || a.charAt(i)=='o' || a.charAt(i)=='u')
			{
				vow++;
			}
			if(a.charAt(i)=='.' || a.charAt(i)=='?' || a.charAt(i)=='!')
			{
				sent++;
			}
			if(a.charAt(i)==' ' && a.charAt(i+1)>=65)
			{
				word++;
			}
		}

		word=word+line;
		cons=alpha-vow;
		
		File file2=new File("Output.txt");
		file2.createNewFile();
		FileWriter writer2=new FileWriter(file2);
		a="";
		
		String a1,a2;
		a1="Number of alphabets: ";
		a2=Integer.toString(alpha);
		a=a+a1+a2+"\r"+"\n";
		
		a1="Number of vowels: ";
		a2=Integer.toString(vow);
		a=a+a1+a2+"\r"+"\n";

		a1="Number of consonants: ";
		a2=Integer.toString(cons);
		a=a+a1+a2+"\r"+"\n";

		a1="Number of words: ";
		a2=Integer.toString(word);
		a=a+a1+a2+"\r"+"\n";

		a1="Number of sentences: ";
		a2=Integer.toString(sent);
		a=a+a1+a2+"\r"+"\n";

		a1="Number of lines: ";
		a2=Integer.toString(line);
		a=a+a1+a2+"\r"+"\n";
		
		writer2.write(a);
		writer2.flush();
		writer2.close();
	}
}	