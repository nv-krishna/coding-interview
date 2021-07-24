# Convert Absolute Path to Canonical Path

## Alias
- Leetcode (71): [Simplify Path](https://leetcode.com/problems/simplify-path/)

## Problem
- Convert an absolute path to canonical path
- Absolute path may contain
   - `..`: Refers to the directory up a level.
   - `.`: Refers to the current directory.
   - Multiple consecutive slashes (like `///`): Should be treated as a single slash (`/`).
- Canonical Path should follow the following rules
   - The path starts with a single slash `/`.
   - The path does not end with a trailing `/`.
   - The path does not have `..` and `.` and multiple consecutive slashes.

## Examples
- Example 1
   - Absolute path: `/home/`
   - Canonical path: `/home`
- Example 2
   - Absolute path: `/home//foo/`
   - Canonical path: `/home/foo`
- Example 3
   - Absolute path: `/a/./b/../../c/`
   - Canonical path: `/c`
- Example 4
   - Absolute path: `/d/a/./b/../../c/`
   - Canonical path: `/d/c`

## Solutions
- Solution 1
   - Remove heading and tailing slashes.
   - Split the absolute path to an string array.
   - Iterate the string array from right to left
      - If the current element is null (it means that this element will be ignored), continue.
      - If the current element is a `..`
         - Set it as null.
         - Find the next left element which is an actual directory name, set it as null.
      - If the current element is `.` or `""`, set it as null.
   - Iterate the string array from left to right
      - Only consider the element which is not null.
  ```java
  public String simplifyPath(String path) {
      if (path.charAt(path.length() - 1) == '/') {
          path = path.substring(0, path.length()-1);
      }
      if (path.length() != 0 && path.charAt(0) == '/') {
          path = path.substring(1, path.length());
      }
        
      String[] array = path.split("/");
        
      for (int i = array.length-1; i >=0; i--) {
          if (array[i] == null) {
              continue;
          }
            
          if (array[i].equals("..")) {                       // If the current is "..",  and delete the previous valid element 
              array[i] = null;                               // delete the current element,
              for (int j = i-1; j >=0; j--) {                // delete the previous element which is a actual directory name
                  if(array[j] != null && !array[j].equals("..") && !array[j].equals(".") && !array[j].equals("")) {
                      array[j] = null;
                      break;
                  }
              }
              continue;
          }
            
          if (array[i].equals(".") || array[i].equals("")) { // If the current is "." or "", delete the the current element
              array[i] = null;
          }
      }
        
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < array.length; i++) {
          if (array[i] != null) {
              sb.append("/" + array[i]);
          }
      }
        
      return sb.toString().length() == 0? "/" : sb.toString();
  }
  ```

  ![dds](https://user-images.githubusercontent.com/8989447/117909742-0c88d800-b298-11eb-986e-354b4215a3ad.png)
