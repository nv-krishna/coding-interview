# Get Top K Frequent Elements from Array

## Alias
- Leetcode (347): [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)

## Problem
- Return the K most frequent elements from the input array.

## Solutions
- Solution 1: Frequency counter + Custom class + Heap (Priority queue)
   - Create a HashMap and count the frequency of each number.
   - Create a priority queue and keep the size of K.
   - Add all elements from queue to array.
  ```java
  class Solution {
      public int[] topKFrequent(int[] nums, int k) {
          Map<Integer,Integer> map = new HashMap<>();        // Create a hashmap and count the frequency of each number
          for(int num : nums) {                            
              map.put(num, map.getOrDefault(num, 0) + 1);
          }
        
          Queue<NumAndFreq> queue = new PriorityQueue<>();   // Create a priority queue and keep the size of k
          for (int key : map.keySet()) {                     
              queue.add(new NumAndFreq(key, map.get(key)));
              if (queue.size() > k) {
                queue.poll();
              }
          }
        
          int[] result = new int[queue.size()];              // Add all elements from queue to array
          int i = 0;
          while(!queue.isEmpty()) {                          
              result[i] = queue.poll().num;
              i++;
          }
        
          return result;
      }
  }

  class NumAndFreq implements Comparable<NumAndFreq> {
      public int num;
      public int freq;
    
      public NumAndFreq (int num, int freq) {
          this.num = num;
          this.freq = freq;
      }
    
      public int compareTo(NumAndFreq nf) {                  // Let priority queue sorted as freq descending order
          return this.freq - nf.freq;
      }
  }
  ```
- Solution 2: Frequency counter + Quickselect
