import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.*;
import java.io.*;

public class input{
	
	public static void main(String[] args) throws Exception{
		Trie T= new Trie();
 		T.Load();
		while(true){
			System.out.println("Enter a word to search (write exit to terminate) \n");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String tmp;		
			while((tmp=br.readLine())!=null)
				if(tmp.equals("exit"))
					return;
				else{
					int re=T.search(tmp);
					if(re==0){
						System.out.println("Do you want to see suggestions? (y/n) : ");
						char c=(char)System.in.read();
						if(c=='y')
						T.Suggest(tmp);
						c=(char)System.in.read();						
					}
			
					System.out.println("-------------------------------------------------------------------------------------------------");
				}

		} 
	}
}

