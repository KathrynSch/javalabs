package lab2.ex1;

import java.util.HashSet;
import java.util.Set;

import lab2.ex1.ColoredWord.Color;

public class Main {

	public static void main(String[] args) {
			
			UndirectedListGraph<String> graph = new UndirectedListGraph<>();
			String a = "A", b="B", c="C", d="D", e="E", f="F", g="G", h="H";
			graph.addVertex(a);
			graph.addVertex(b);
			graph.addVertex(c);
			graph.addVertex(d);
			graph.addVertex(e);
			graph.addVertex(f);
			
			//Set<Word> vertices = null;
			//graph.addVertices(vertices);
			
			graph.addEdge(a, b);
			graph.addEdge(b, c);
			graph.addEdge(c, d);
			graph.addEdge(c, a);
			graph.addEdge(d, b);
			graph.addEdge(b, e);
			graph.addEdge(c, f);
			
			System.out.println(graph.toString());
			
			Set<String> verticesToAdd = new HashSet<>();
			verticesToAdd.add(f);
			verticesToAdd.add(g);
			verticesToAdd.add(h);
			//graph.addVertices(verticesToAdd);
			
			Set<Word> wordsToAdd = new HashSet<>();
			Word word1 = new Word("w1");
			Word word2 = new Word("w2");
			Word word3 = new Word("w3");
			wordsToAdd.add(word1);
			wordsToAdd.add(word2);
			wordsToAdd.add(word3);
			//graph.addVertices(wordsToAdd);
			
			Set<ColoredWord> coloredWordsToAdd = new HashSet<>();
			ColoredWord word4 = new ColoredWord("w4", Color.BLUE);
			ColoredWord word5 = new ColoredWord("w5", Color.GREEN);
			ColoredWord word6 = new ColoredWord("w6",Color.PURPLE);
			coloredWordsToAdd.add(word4);
			coloredWordsToAdd.add(word5);
			coloredWordsToAdd.add(word6);
			graph.addVertices(coloredWordsToAdd);
			
			System.out.println(graph.toString());

			DepthFirstSearch dfs = new DepthFirstSearch();
			dfs.execute(graph, a);
	
		}
}
