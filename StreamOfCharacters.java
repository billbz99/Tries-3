// Time Complexity : O(M * N) for building the trie, O(N) for searching in the trie
// Space Complexity : O(1)

class StreamChecker {

	TrieNode root;
	StringBuilder sb;

    public StreamChecker(String[] words) {
    	root = new TrieNode();
    	sb = new StringBuilder();

    	constructTrie(words);    
    }
    
    private void constructTrie(String[] words) {
    	for (String word : words) {

    		TrieNode cursor = root;
    		for (int i = word.length() - 1; i >= 0; i--) {
    			char ch = word.charAt(i);
    			if (cursor.children[ch - 'a'] == null) {
    				cursor.children[ch = 'a'] = new TrieNode();
    			}

    			cursor = cursor.children[ch - 'a'];
    		}
    		cursor.isEndOfWord = true;
    	}
    }

    public boolean query(char letter) {
        //sb.append(letter);
    	sb.insert(0, letter);

        TrieNode cursor = root;
        for (int i = 0; i < sb.length(); i++) {
        	char ch = sb.charAt(i);

        	if (cursor.children[ch - 'a'] == null) return false;
        	cursor = cursor.children[ch - 'a'];
        	if (cursor.isEndOfWord) {
        		return true;
        	}
        }

        return false;
    }
}

class TrieNode {
	TrieNode[] children;
	boolean isEndOfWord;

	TrieNode() {
		children = new TrieNode[26];
	}
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */