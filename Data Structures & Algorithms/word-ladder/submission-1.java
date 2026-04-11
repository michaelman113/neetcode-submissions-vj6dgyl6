public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Edge case case Goku (Super) Super Saiyan God Super Saiyan
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }
        Set<String> words = new HashSet<>(wordList);
        int res = 0;
        // Queue for transformation sequence
        Queue<String> q = new LinkedList<>();
        // Adds begin word to start search
        q.offer(beginWord);
        
        while (!q.isEmpty()) {
            res++;
            // Iterates through all words at current level
            for (int i = q.size(); i > 0; i--) {
                String node = q.poll();
                if (node.equals(endWord)) {
                    return res;
                }
                // Iterates through each character of the current word
                for (int j = 0; j < node.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        // Tries to replace the character at the current position
                        if (c == node.charAt(j)) { 
                            continue;
                        }
                        // New word with the replaced character
                        String nei = node.substring(0, j) + c + node.substring(j + 1);
                        // If new word is in the list, add to queue sequence
                        if (words.contains(nei)) {
                            q.offer(nei);
                            words.remove(nei);
                        }
                    }
                }
            }
        }
        // if the bfs completes, and the word isn't found, it'll return 0
        return 0;
    }
}
