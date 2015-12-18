import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.BufferedReader;

public class Trie{
	private Node root;
	
	public Trie(){
		this.root=new Node(' ');
	}

	public void Load() throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(new File("dictionary.txt")));
		String tmp;		
		while((tmp=br.readLine())!=null)
			this.insert(tmp);
		System.out.println("Loading complete");
	}

 	public void insert(String S){
		Node current=this.root;
		String s=S.toLowerCase();
		if(s.length()==0){
			current.marker=true;
			return;
		}
		for(int i=0;i<s.length();i++){
			if(Character.isLetter(s.charAt(i))){
				if(current.child[(int)(s.charAt(i)-'a')]!=null){
					current= current.child[(int)(s.charAt(i)-'a')];
				}else{
					current.child[(int)(s.charAt(i)-'a')]= new Node(s.charAt(i));
					current= current.child[(int)(s.charAt(i)-'a')];
				}
			}
		}
		current.marker= true;
	}

	public int search(String S){
		Node current= this.root;
		String s=S.toLowerCase();
		while(current!=null){
			for(int i=0;i<s.length();i++){
				//if(Character.isLetter(s.charAt(i))){
				if((int)(s.charAt(i)-'a')>=0 && (int)(s.charAt(i)-'a')<26){ 
					if(current.child[(int)(s.charAt(i)-'a')]==null){
						System.out.println("Cannot find word: " + S);
						return -1;
					}else
						current= current.child[(int)(s.charAt(i)-'a')];
				}		
			}
	
				if(current.marker== true){
					//System.out.println("Found word: " + S);
					return 1;
				}else{
					System.out.println("Cannot find word: " + S);					
					//this.Suggest(s);
					return 0;
				}
		}
		return -2;
	}

	public void Suggest(String s){
		Node current= this.root;
		for(int i=0;i<s.length();i++)
			current= current.child[(int)(s.charAt(i)-'a')];
		DFS(s,current);
	}

	public void DFS(String s,Node current){
		if(current.marker==true)
			System.out.println("Suggested word: " + s);		
		if(current== null)
			return;		
		for(int i=0;i<26;i++){
			if(current.child[i]!= null){
				DFS(s+current.child[i].content,current.child[i]);
			}
		}
	}

}
