import java.util.*;
import java.util.HashMap;
class Node
{
	String key;
	int value;
	public Node(String key,int value)
	{
		this.key=key;
		this.value=value;
	}
}
public class hashmap
{
	public static void main(String[] args) {
		//initialization of hashmap
		HashMap<Integer, Node> MyMapNode = new HashMap<>(); 
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The paragraph:");
		String para=sc.nextLine();
		//for separating each word in a paragraph
		String[] words = para.split("\\W+");

		for(int i=0;i<words.length;i++)
		{
			//gets hash code for every word
			int hash=hashCode(words[i]);
			//if hashmap is null 
			if(MyMapNode.get(hash)==null)
			{
				//creating node with key and value
				Node temp=new Node(words[i],1);
				//adding word to hashmap
				MyMapNode.put(hash,temp);
			}
			else
			{
				//if already word exists then value increases
				Node temp=MyMapNode.get(hash);
				temp.value++;
			}
		}
		while(true)
		{
			int choice;
			System.out.println("1.Find Frequency of Word\n2.Remove an Element\n3.Exit");
			choice=sc.nextInt();
			int temp;
			switch(choice)
			{
			case 1:
				System.out.print("Enter The word:");
				temp=findValue(MyMapNode);
				System.out.println(temp);
				break;
			case 2:System.out.println("Enter the Word:");
			MyMapNode=removeWord(MyMapNode);
			break;
			case 3:System.exit(0);
			break;
			default:System.out.println("Entered Wrong value");
			break;
			}
		}
	}
	public static int hashCode(String Str)
	{
		int hash=0;
		for(int i=0;i<Str.length();i++)
		{
			//eg:-rat and tar (1 * r->ASCII value)+(2*a->ASCII value)+(3*t->ASCII value)
			int j=i+1;
			j=j*Str.charAt(i);
			hash=hash+j;
		}
		return hash;
	}
	//method to find how many times repeated
	public static int findValue(HashMap<Integer, Node> MyMapNode)
	{

		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String word=sc.nextLine();
		int temp=hashCode(word);
		Node x=MyMapNode.get(temp);
		return x.value;

	}

	public static HashMap<Integer, Node> removeWord(HashMap<Integer, Node> MyMapNode)
	{

		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		String word=sc.nextLine();
		int temp=hashCode(word);
		MyMapNode.remove(temp);
		return MyMapNode;

	}
}