public class Node{
	char content;
	boolean marker;
	Node[] child;

	public Node(){
		this.marker=false;
		this.child=new Node[26];
		for(int i=0;i<26;i++)
			this.child[i]=null;
	}

	public Node(char c){
		this.content=c;
		this.marker=false;
		this.child=new Node[26];
		for(int i=0;i<26;i++)
			this.child[i]=null;
	}
}
