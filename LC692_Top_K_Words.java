import java.util.List;
import java.util.Map;

/**
 * Created by donezio on 12/4/18.
 */
public class LC692_Top_K_Words {

    // O(NlgK + N) for min heap solution
    // O(N * average length of words) for bucket sort and trie solution
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String word: words) {
            map.put(word, map.getOrDefault(word,0) + 1);
        }

        Node[] bucket = new Node[words.length + 1];

        // add words
        for (Map.Entry<String, Integer> e: map.entrySet()) {
            if (bucket[e.getValue()] == null) {
                bucket[e.getValue()] = new Node();
            }
            addWord(bucket[e.getValue()], e.getKey());
        }

        // get words
        List<String> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (res.size() == k) break;
            if (bucket[i] != null) {
                getWord(bucket[i], res, k);
            }
        }
        return res;
    }

    private void addWord(Node node, String str) {
        Node cur = node;
        for (int i = 0; i < str.length(); i++) {
            if (cur.children[str.charAt(i) - 'a'] == null) {
                cur.children[str.charAt(i) - 'a'] = new Node();
            }
            cur = cur.children[str.charAt(i) - 'a'];
        }
        cur.word = str;
    }

    private void getWord(Node node, List<String> res, int k) {
        if (node == null) return;
        if (res.size() == k) return;
        if (node.word != null) res.add(node.word);
        for (Node tmp: node.children) {
            if (tmp != null) {
                getWord(tmp,res,k);
            }
        }
    }

    class Node {
        String word;
        Node[] children;
        Node () {
            this.word = null;
            children = new Node[26];
        }
    }
}
