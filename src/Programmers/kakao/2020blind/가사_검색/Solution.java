import java.util.*;

class Solution {

    TrieNode fRoot;
    TrieNode lRoot;

    public int[] solution(String[] words, String[] queries) {
        int[] answer = {};
        
        answer = new int[queries.length];
        
        makeTrieNode(words);

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            boolean isFirst = (query.charAt(0) != '?') ? true : false;
            TrieNode node = (isFirst) ? fRoot: lRoot;
            int index = (isFirst) ? 0 : query.length() - 1;

            int cnt = 0;
            char target;
            
            if (node.c == query.charAt(index)) {
                answer[i] = node.cnt.getOrDefault(query.length(), 0);
                continue;
            }

            while((target = query.charAt(index)) != '?') {
                cnt = 0;

                if (isFirst) index++;
                else index--;

                for (TrieNode n: node.next) {
                    if (n.c == target) {
                        cnt = n.cnt.getOrDefault(query.length(), 0);
                        node = n;
                        break;
                    }
                }

                if (cnt == 0) break;
            }

            answer[i] = cnt;
        }
        
        return answer;
    }

    public void makeTrieNode(String[] words) {
        fRoot = new TrieNode('?');
        lRoot = new TrieNode('?');

        for (String word: words) {
            TrieNode fnode = fRoot;
            TrieNode lnode = lRoot;
            int len = word.length();
            fnode.cnt.put(len, fnode.cnt.getOrDefault(len, 0)+1);
            lnode.cnt.put(len, lnode.cnt.getOrDefault(len, 0)+1);

            for (int i = 0; i < len; i++) {
                int reverseIdx = len - i - 1;

                char a = word.charAt(i);
                char b = word.charAt(reverseIdx);

                fnode = addNext(fnode, a, len);
                // System.out.println(word + " " + i + " " + a + " " + fnode.cnt.get(len));
                lnode = addNext(lnode, b, len);
                // System.out.println(word + " " + reverseIdx + " " + b + " " + lnode.cnt.get(len));
            }
        }
    }

    private TrieNode addNext(TrieNode node, char c, int len) {

        for (TrieNode n: node.next) {
            if (n.c == c) {
                n.cnt.put(len, n.cnt.getOrDefault(len, 0)+1);
                return n;
            }
        }

        TrieNode newNode = new TrieNode(c);
        newNode.cnt.put(len, 1);
        node.next.add(newNode);
        return newNode;
        
    }
}

class TrieNode {
    char c;
    Map<Integer, Integer> cnt = new HashMap<>();;
    List<TrieNode> next = new ArrayList<>();

    TrieNode(char c) {
        this.c = c;
    }

    TrieNode() {

    }
}