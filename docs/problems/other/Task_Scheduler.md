# Task Scheduler

## Alias
- Leetcode (621): [Task Scheduler](https://leetcode.com/problems/task-scheduler/)

## Problem
- There are a list of tasks that CPU needs to finish.
   - Tasks are represented in upper-case English letters.
   - Tasks could be done in any order. 
   - Each task is done in one unit of time.
   - For each unit of time, the CPU could complete either one task or just be idle.
- There is a cooldown period between two same tasks.
- Return the least number of units of times that the CPU will take to finish all the given tasks.

## Solutions
- Solution 1: Greedy
     
     ![de1](https://user-images.githubusercontent.com/8989447/116152501-3ab8c600-a6a3-11eb-977b-7a4df6cf4a2e.png)
     
   - The most frequent task frames the working sequence.
   - Use idles to fill the gap of most frequent task.
   - Replace the idle slots by other actual tasks from 2nd most frequent tasks to least frequency task.
   - At the end, see how many idle slots remaining.
      - If there is still idle slots remaining, the total period = idleSlots + tasks.length
      - If there is no slots remaining, the total period = tasks.length.
        ![de2](https://user-images.githubusercontent.com/8989447/116153904-40afa680-a6a5-11eb-8bc8-ab1a3a4a8e09.png)
        ![de3](https://user-images.githubusercontent.com/8989447/116153938-4907e180-a6a5-11eb-9a6c-454dfb64e5b1.png)

  ```java
  public int leastInterval(char[] tasks, int n) {
      int[] taskFrequency = new int[26];           // Create an array to count the frequency of each task (A-Z)
      for (char task : tasks) {
          taskFrequency[task-'A']++; 
      }
        
      Arrays.sort(taskFrequency);                  // Sort the task frequency array 
                                                   // and make the most frequency at the end of the array
      int maxFrequency = taskFrequency[25];        // Get the frequency of the most frequent task
      int idlePeriods   = (maxFrequency - 1) * n;  // Calculate how many idle periods needed to fill the gap of most frequent task 
    
      for (int i=24; i>=0; i--) {                  // Replace the idles with other actual tasks
          idlePeriods = idlePeriods - Math.min(taskFrequency[i], maxFrequency - 1);
      }
        
      if (idlePeriods > 0) {                       // If there are still some idles remaining
          return idlePeriods + tasks.length;       
      } else {
          return tasks.length;
      }
  }
  ```
- Solution 2: Frequency counter + Custom class
   - Use frequency counter to counter the frequency of each task.
   - Create a custom class to represent each task and its frequency and number of block period
   - Create a list to store the list of task.
   - Each time, get the unblock and the most frequency task to execute
      - If there is no unblocked task:
         - Idle
         - Reduce the number of block period of each task by 1
      - If there is a unblock task:
         - Execute the task
         - Update the frequency and the number of block period of it
         - Reduce the number of block period of each task (except the current taks) by 1
         - If there is no frequency for it, remove it.
  ```java
  class Solution {
      private List<Task>      taskList;
      private List<Character> sequenceList;
    
      public int leastInterval(char[] tasks, int n) {
          this.taskList     = new ArrayList<>();
          this.sequenceList = new ArrayList<>();
        
          Map<Character, Integer> taskMap = new HashMap<>();
          for(char task : tasks) {
              taskMap.put(task, taskMap.getOrDefault(task, 0) + 1);
          }
        
          for(char task : taskMap.keySet()) {
              this.taskList.add(new Task(task, taskMap.get(task), 0));
          }
        
          Collections.sort(taskList);     // Get all the unblock tasks, and then get the most frequency task
        
          while(!taskList.isEmpty()) {
              Task leftTask = this.taskList.get(0);
            
              if (leftTask.blockCount > 0) {  // If there is no task is free
                  // Add an idle task
                  this.sequenceList.add('?'); 
                
                  // Reduce blockCount by 1 on the tasks which blockCount > 0
                  for (int i = 0; i < this.taskList.size(); i++) {
                      if (taskList.get(i).blockCount > 0) {
                          taskList.get(i).blockCount = taskList.get(i).blockCount - 1;
                      }
                  }
              } else {                        // If there is a task free
                  // Let leftTask run
                  this.sequenceList.add(leftTask.name);
                               
                  // Update remaining frequency and block count of leftTask
                  leftTask.frequency = leftTask.frequency - 1;
                  leftTask.blockCount = n;
                
                  // Reduce blockCount by 1 on the tasks which blockCount > 0
                  for (int i = 1; i < this.taskList.size(); i++) {
                      if (taskList.get(i).blockCount > 0) {
                          taskList.get(i).blockCount = taskList.get(i).blockCount - 1;
                      }
                  }
                
                  // If no frequency need to execute for leftTask, remove it from list
                  if (leftTask.frequency == 0) {
                      this.taskList.remove(0);
                  }
              }
            
              Collections.sort(this.taskList);
          }
        
          return this.sequenceList.size();
      }
  }

  class Task implements Comparable<Task> {
      public char name;
      public int  frequency;        // The remaining frequency this task need to run
      public int  blockCount;       // How many periods this task need to be blocked
    
      public Task(char name, int frequency, int blockCount) {
          this.name       = name;
          this.frequency  = frequency;
          this.blockCount = blockCount;
      }
      
      public int compareTo(Task t) {
          int result = this.blockCount - t.blockCount;      // 1st priority: Get the unblock tasks (blockCount = 0) first
          if (result != 0) {
              return result;
          } else {
              return -(this.frequency - t.frequency);       // 2nd priority: Get most frequency task first
          }
      }
  }
  ```

## References
- https://www.youtube.com/watch?v=eGf-26OTI-A
