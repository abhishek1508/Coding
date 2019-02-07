public class TrieInsertAndSearch {

    public static class Trie {
        Trie[] trieChild = new Trie[26];
        boolean isEndOfWord;

        Trie() {
            this.isEndOfWord = false;
            for (int i = 0; i < 26; i++) {
                trieChild[i] = null;
            }
        }
    }

    private static Trie root;

    private static void insert(String key) {
        int length = key.length();
        int index;
        Trie crawl = root;
        for (int i = 0; i < length; i++) {
            index = key.charAt(i) - 'a';
            if (crawl.trieChild[index] == null) {
                crawl.trieChild[index] = new Trie();
            }
            crawl = crawl.trieChild[index];
        }
        crawl.isEndOfWord = true;
    }

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        root = new Trie();
        for (String key : keys) {
            insert(key);
        }
    }
}
