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

public class trietest{
	
	public static void main(String[] args) throws Exception{
		Trie T= new Trie();
 		T.Load();
		String pattern = "([\\S]*[A-Z]+[a-z]*[1-9]*[\\S]*)";
		Pattern r = Pattern.compile(pattern);
		BufferedReader br=new BufferedReader(new FileReader(new File(args[0])));
		String line;		
		while((line=br.readLine())!=null){	
			Matcher m = r.matcher(line);
			for(int i=0;m.find();i++){
			 	String tmp=m.group(1);
				T.search(tmp);
			}
		}
	}
}
