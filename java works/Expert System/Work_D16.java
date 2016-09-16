package work;

import java.util.*;

public class Work_D16 {

	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Give me your idea...");
		String raw = input.nextLine();
		
		List<String> sentences = split_text(raw);
		System.out.println("Got the SENTENCES list...\n" + sentences);
		//List<ArrayList<String>> words = split_words(sentences);
		List<List<String>> words = split_words(sentences);
		System.out.println("Got the WORDS list...\n" + words);
		
	}
	
	public static  List<String> split_text(String text){
		System.out.println("Spliting TEXT...\nHere is the TEXT...\n" + text);
		
		List<String> list = new ArrayList<>(Arrays.asList());
		
		for(String sentence: text.split("\\.")){
			
			list.add(sentence);
			
		}
		
		System.out.println("Done Spliting SENTENCES...\nRESULT:  \n" + list);
		
		return list;
		
	}
	
	public static List<List<String>> split_words(List<String> sentences){
		System.out.println("Spliting SENTENCES...\nHere are the SENTENCES...\n + sentences");
		
		List<List<String>> list = new ArrayList<List<String>>();
		
		for(int n = 0; n < sentences.size(); n++){
			
			List<String> word_holder = new ArrayList<String>();
			
			for(String words: sentences.get(n).split(" ")){
				
				word_holder.add(words);
				
			}
			
			System.out.println("Words From Sentence " + n + ":\n" + word_holder);
			list.add(word_holder);
			
		}
		
		return list;
		
	}
	
	/*public static List<ArrayList<String>> split_words(List<String> sentences){
		System.out.println("Spliting SENTENCES...\nHere are the SENTENCES...\n" + sentences);
		
		List<String> word_holder = new ArrayList<>(Arrays.asList());
		ArrayList<String> words_holder = new ArrayList<>(Arrays.asList());
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		for(int n = 0; n < sentences.size(); n++){
			
			for(String words: sentences.get(n).split(" ")){
				
				word_holder.add(words);
				
			}
			
			System.out.println("WORD HOLDER:  " + word_holder);
			words_holder.addAll(word_holder);
			System.out.println("WORDS HOLDER:  " + words_holder);
			list.add(words_holder);
			System.out.println("LIST:  " + list);
			word_holder.clear();
			words_holder.clear();
			
		}
			
		System.out.println("Done Spliting WORDS...\nRESULT:  \n" + list);
		//System.out.println("Line 1: " + sentences.get(1));
		
		return list;
		
	}*/
	
}