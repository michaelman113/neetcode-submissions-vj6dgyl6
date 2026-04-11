class Solution {

    public String encode(List<String> strs) {
        // Use StringBuilder for efficient string concatenation in a loop.
        StringBuilder encodedString = new StringBuilder();
        
        // Iterate over each string in the input list.
        for (String s : strs) {
            // Append the length of the string, the delimiter, and the string.
            encodedString.append(s.length()).append('#').append(s);
        }
        
        // Convert the StringBuilder to a String and return it.
        return encodedString.toString();
    }

    /**
     * Decodes a single string back into a list of strings.
     *
     * @param s The single string to decode.
     * @return The original list of strings.
     */
    public List<String> decode(String s) {
        // Create a list to store the decoded strings.
        List<String> decodedStrings = new ArrayList<>();
        int i = 0; // A pointer to traverse the encoded string.

        // Loop as long as the pointer is within the bounds of the string.
        while (i < s.length()) {
            // Find the position of the next '#' delimiter, starting from 'i'.
            int delimiterPos = s.indexOf('#', i);
            
            // Extract the substring representing the length and parse it to an integer.
            int length = Integer.parseInt(s.substring(i, delimiterPos));
            
            // Calculate the start and end positions of the actual string.
            int stringStart = delimiterPos + 1;
            int stringEnd = stringStart + length;
            
            // Extract the string using the calculated positions and add it to the list.
            decodedStrings.add(s.substring(stringStart, stringEnd));
            
            // Move the pointer to the beginning of the next encoded block.
            i = stringEnd;
        }
        
        return decodedStrings;
    }
}
