import java.util.*;

public class LC_127_WordLadder {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ladderLength("hit", "cog", wordList));
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(beginWord, 1));
        while (!queue.isEmpty()) {
            WordNode fromQueue = queue.poll();
            Iterator<String> it = wordList.iterator();
            while (it.hasNext()) {
                String fromDictionary = it.next();
                String word = fromQueue.word;
                if (isOneCharacterDiff(fromDictionary, word)) {
                    queue.add(new WordNode(fromDictionary, fromQueue.length + 1));
                    it.remove();
                    if (fromDictionary.equalsIgnoreCase(endWord)) {
                        return fromQueue.length + 1;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isOneCharacterDiff(String fromDictionary, String fromQueue) {
        int count = 0;
        for (int i = 0; i < fromDictionary.length(); i++) {
            if (fromDictionary.charAt(i) != fromQueue.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    private static class WordNode {
        WordNode(String word, int length) {
            this.word = word;
            this.length = length;
        }
        public String word;
        public int length;
    }
}
