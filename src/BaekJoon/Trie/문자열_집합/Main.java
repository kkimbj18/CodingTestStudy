import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] S = new String[N];

        for (int i = 0; i < N; i++) {
            S[i] = br.readLine();
        }

        String[] target = new String[M];

        for (int i = 0; i < M; i++) {
            target[i] = br.readLine();
        }

        int answer = 0;

        Trie trie = new Trie();

        for (String s : S) {
            TrieNode tNode = trie.rootNode;
            char[] chars = s.toCharArray();

            for (char c : chars) {
                tNode.next.putIfAbsent(c, new TrieNode());
                tNode = tNode.next.get(c);
            }

            tNode.isLast = true;
        }

        for (String t : target) {
            TrieNode tNode = trie.rootNode;
            char[] chars = t.toCharArray();
            boolean isLast = false;

            for (char c : chars) {
                isLast = false;

                tNode = tNode.next.get(c);

                if (tNode == null)
                    break;

                isLast = tNode.isLast;
            }

            if (isLast)
                answer++;
        }

        System.out.println(answer);
    }
}

class TrieNode {
    boolean isLast;
    Map<Character, TrieNode> next;

    TrieNode() {
        isLast = false;
        next = new HashMap<Character, TrieNode>();
    }
}

class Trie {
    TrieNode rootNode;

    Trie() {
        rootNode = new TrieNode();
    }
}
