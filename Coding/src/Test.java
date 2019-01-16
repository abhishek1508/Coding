import java.util.*;

public class Test {
    public static void main(String[] args) {
        //System.out.println(getRepeatedCharacter("geeksforgeeks"));
        //System.out.println(isBalanced("]}(}}"));
        //System.out.println(reversedString("i.like.this.program.very.much"));
        int length = lengthOfLongestSubstring("abcad");
        System.out.println(length);
    }

    public static String reversedString(String input) {
        String[] array = input.split("\\.");
        int start = 0;
        int end = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (start >= end) {
                break;
            } else {
                String temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
        StringBuilder builder = new StringBuilder(array[0]);
        builder.append(".");
        for (int i = 1; i < array.length; i++) {
            builder.append(array[i]);
            if (i != array.length -1) {
                builder.append(".");
            }
        }
        return builder.toString();
    }

    public static String isBalanced(String input) {
        char[] array = input.toCharArray();
        String balancedState = "balanced";
        Stack<Character> stack = new Stack<>();
        for (char currChar : array) {
            if (currChar == '(' || currChar == '[' || currChar == '{') {
                stack.push(currChar);
            } else if (stack.size() > 0 && (currChar == ')' || currChar == ']' || currChar == '}')) {
                char poppedChar = stack.pop();
                if (currChar == ')' && poppedChar != '('
                        || currChar == '}' && poppedChar != '{'
                        || currChar == ']' && poppedChar != '[') {
                    balancedState = "unbalanced";
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            balancedState = "unbalanced";
        }
        return balancedState;
    }

    private static String getRepeatedCharacter(String input) {
        Map<Character, Integer> characterCount = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (!characterCount.containsKey(c)) {
                characterCount.put(c, 1);
            } else {
                characterCount.put(c, characterCount.get(c)+1);
            }
        }
        String output = "-1";
        for (Map.Entry pair : characterCount.entrySet()) {
            Character key = (Character) pair.getKey();
            if (characterCount.get(key) > 1) {
                output = key.toString();
                break;
            }
        }
        return output;
    }


    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                boolean hasRepeating = hasRepeating(s.substring(i,j));
                if (!hasRepeating) {
                    int subStringLength = s.substring(i,j).length();
                    if (subStringLength > maxLength) {
                        maxLength = subStringLength;
                    }
                }
            }
        }
        return maxLength;
    }

    private static boolean hasRepeating(String s) {
        boolean[] array = new boolean[256];
        Arrays.fill(array, false);
        for (int i = 0; i < s.length(); i++) {
            int index = (int)s.charAt(i);
            if (array[index]) {
                return true;
            }
            array[index] = true;
        }
        return false;
    }
}
