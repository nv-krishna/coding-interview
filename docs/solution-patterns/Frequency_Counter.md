# Frequency Counter

- [**Concepts**](#concepts)
- [**Benefit**](#benefit)
- [**Construction**](#construction)
- [**Problems can use this pattern**](#problems-can-use-this-pattern)

## Concepts
- Use an object to record unique values and the frequency of each unique values.

## Benefit
- Avoid the need for nested loops or O(n<sup>2</sup>) operations.

## Construction
- Java HashMap
  ```java
  Map<Integer,Integer> map = new HashMap<>();
        
  for(int num : nums) {                            
      map.put(num, map.getOrDefault(num, 0) + 1);
  }
  ```
- Java Array
   - Situation
      - You only need to count the occurrences of 26 English letters in lowercase or uppercase.
   - Code
      ```java
      int[] counter = new int[26];
      Arrays.fill(counter, 0);
      for (int i = 0; i < str.length(); i++) {
          counter[ch-'a']++;          // counter[ch-'A'] for uppercase English letter
      }
      ```
   - Examples
      - [Can Characters of String Form Palindrome]()
      - [Task Scheduler]()

## Problems can use this pattern
- Frequency problems
   - [Get Top K Frequent Elements from Array](../../docs/problems/array/Get_Top_K_Frequent_Elements_From_Array.md)
   - [Get Top K Frequent Words from Array](../../docs/problems/array/Get_Top_K_Frequent_Words_From_Array.md)
   - [Can Characters of String Form Palindrome](../../docs/problems/string/palindrome/Can_Characters_Of_String_Form_Palindrome.md)
