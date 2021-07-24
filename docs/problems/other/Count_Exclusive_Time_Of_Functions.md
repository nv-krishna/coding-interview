# Count Exclusive Time of Functions

## Alias
- Leetcode (636): [Exclusive Time of Functions](https://leetcode.com/problems/exclusive-time-of-functions/)

## Problem
- There are `n` functions, each function has a unique ID between `0` and `n-1`.
- There are a list of logs:
   - Format: `{function_id}:{"start" | "end"}:{timestamp}`
- Count the exclusive time of functions into an array.
- Edge cases
   - A function can be called multiple times, possibly recursively.

## Example
- Example 1
   - Logs: `["0:start:0","1:start:2","1:end:5","0:end:6"]`
   - Output: `[3,4]`
   - Explanation
      - Function 0 runs `0~2` and `6~6`, total is 3.
      - Function 1 runs `2~5`, total is 4.

      ![fun1](https://user-images.githubusercontent.com/8989447/117215792-fa042f80-adbb-11eb-9e5f-f359d5750b78.png)

- Example 2
   - Logs: `["0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"]`
   - Ouput: `[8,1]`
   - Explanation
      - Function 0 runs `0~2`, `2~5`, `6~6`, `8~8`, total is 8.
      - Function 1 runs `7~7`, total is 7.
      
      ![func1](https://user-images.githubusercontent.com/8989447/117216416-f4f3b000-adbc-11eb-8009-0190e3c240cf.png)


## Solutions
- Solution 1: Stack
  ```java
  public int[] exclusiveTime(int n, List<String> logs) {
      int[] result = new int[n];
      Stack<String> stack = new Stack<>();
        
      int    lastTimeSt = 0;
      String lastAction = "";
      for (int i = 0; i < logs.size(); i++) {
          int    curFuncId = Integer.parseInt(logs.get(i).split(":")[0]);
          String curAction = logs.get(i).split(":")[1];
          int    curTimeSt = Integer.parseInt(logs.get(i).split(":")[2]);
            
          if (stack.isEmpty()) {
              stack.push(logs.get(i));
          } else {
              int    topFuncId = Integer.parseInt(stack.peek().split(":")[0]);
              String topAction = stack.peek().split(":")[1];
                
              if (topFuncId == curFuncId && topAction.equals("start") && curAction.equals("end")) {
                  stack.pop();
                  int length = curTimeSt - lastTimeSt;
                  if (lastAction.equals("start") && curAction.equals("end")) {         // cover: start 2 end 5 but length is 4 
                      length++;
                  }
                  result[topFuncId] = result[topFuncId] + length;
              } else {
                  stack.push(logs.get(i));
                  int length = curTimeSt - lastTimeSt;
                    
                  if (lastAction.equals("end") && curAction.equals("start")) {         // cover: end 3 start 4 length is 0
                      length--;
                  }
                  result[topFuncId] = result[topFuncId] + length;
              }
          }
            
          lastTimeSt = curTimeSt;
          lastAction = curAction;
      }
        
      return result;
  }
  ```
