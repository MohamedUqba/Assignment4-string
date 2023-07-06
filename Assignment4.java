package assignments;

import java.util.LinkedHashSet;

public class Assignment4 {
	
	public static void main(String[] args) {
		System.out.println("---------------------------------Question first-----------------------------------------");
        String string1 = "Hello World";
        String result = duplicateRemovel(string1);
        System.out.println("Original String: " + string1);
        System.out.println("String with Duplicates Removed: " + result);
        
        System.out.println("---------------------------------Question two------------------------------------------");
        
        System.out.println("Duplicate characters in the string: " + string1);
        printDuplicateCharacters(string1);
        
        System.out.println("length is : "+string1.length());
        
        System.out.println("---------------------------------Question three-----------------------------------------");
        String palindrome = "acbca";
        boolean isPalindrome = isPalindrome(palindrome);

        if (isPalindrome) {
            System.out.println(palindrome + " is a palindrome.");
        } else {
            System.out.println(palindrome + " is not a palindrome.");
        }
        
        System.out.println("---------------------------------Question four-----------------------------------------");

        String input = "aabeio!";
        int vowelCount = 0;
        int consonantCount = 0;
        int specialCharCount = 0;

        // Remove whitespace and convert the string to lowercase for easier comparison
        String lowercaseInput = input.replaceAll("\\s+", "").toLowerCase();

        for (int i = 0; i < lowercaseInput.length(); i++) {
            char ch = lowercaseInput.charAt(i);

            if (Character.isLetter(ch)) {
                if (isVowel(ch)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            } else {
                specialCharCount++;
            }
        }

        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);
        System.out.println("Number of special characters: " + specialCharCount);
    
        System.out.println("---------------------------------Question five-----------------------------------------");
        
        String str1 = "listen";
        String str2 = "silent";

        boolean isAnagram = checkAnagram(str1, str2);

        if (isAnagram) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
        System.out.println("---------------------------------Question six-----------------------------------------");
        
        String stringPangram = "The quick brown fox jumps over the lay dogz";

        boolean isPangram = checkPangram(stringPangram);

        if (isPangram) {
            System.out.println(stringPangram + " is a pangram.");
        } else {
            System.out.println(stringPangram + " is not a pangram.");
        }
 
        System.out.println("---------------------------------Question seven-----------------------------------------");
        
        String stringUniqueChars = "Hello World";
        
        boolean hasUniqueChars = hasUniqueCharacters(stringUniqueChars);

        if (hasUniqueChars) {
            System.out.println(stringUniqueChars + " contains all unique characters.");
        } else {
            System.out.println(stringUniqueChars + " does not contain all unique characters.");
        }
    
        
	
        System.out.println("---------------------------------Question eight-----------------------------------------");
        
        String stringMaxOccurring = "Hello World";
        
        char maxOccurringChar = findMaxOccurringCharacter(stringMaxOccurring);

        System.out.println("Maximum occurring character in " + stringMaxOccurring + " is: " + maxOccurringChar);
    
        
        
}//main method end

    
    

	//remove duplicate method
    public static String duplicateRemovel(String str) {
        char[] chars = str.toCharArray();

        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : chars) {
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : set) {
            sb.append(c);
        }

        return sb.toString();
    }
    
	//print duplicate method
    public static void printDuplicateCharacters(String str) {
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (currentChar != ' ') {
                for (int j = i + 1; j < str.length(); j++) {
                    if (currentChar == str.charAt(j)) {
                        System.out.println(currentChar);
                        break;
                    }
                }

                str = str.replace(currentChar, ' '); // Replace found duplicates with space
            }
        }
    }
    
    public static boolean isPalindrome(String string) {
    	
    	int leftSide = 0;
    	int rightSide = string.length() -1;
    	
    	while (leftSide < rightSide) {
    		if(string.charAt(leftSide) != string.charAt(rightSide))
    			return false;
    
    	leftSide++;
    	rightSide--;
    	}
    	return true;
    }
    
    
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    
    
    //question five
    public static boolean checkAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] count = new int[26]; // Assuming input strings contain only lowercase English letters

        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;
        }

        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }
    
    
    //question six
    public static boolean checkPangram(String str) {
        int[] count = new int[26]; // Assuming input string contains only uppercase or lowercase English letters

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            if (ch >= 'a' && ch <= 'z') {
                count[ch - 'a']++;
            }
        }

        for (int value : count) {
            if (value == 0) {
                return false;
            }
        }

        return true;
    }
    
    
    //question seven
    public static boolean hasUniqueCharacters(String str) {
        boolean[] charSet = new boolean[256]; // Assuming extended ASCII characters

        for (int i = 0; i < str.length(); i++) {
            int charValue = str.charAt(i);
            if (charSet[charValue]) {
                return false;
            }
            charSet[charValue] = true;
        }

        return true;
    }
    
    public static char findMaxOccurringCharacter(String str) {
        int[] charCount = new int[256]; // Assuming extended ASCII characters
        int maxCount = 0;
        char maxChar = ' ';

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charCount[ch]++;

            if (charCount[ch] > maxCount) {
                maxCount = charCount[ch];
                maxChar = ch;
            }
        }

        return maxChar;
    }

    
    
}






