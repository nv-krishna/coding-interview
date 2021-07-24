# First Bad Version

## Alias
- Leetcode (278): [First Bad Version](https://leetcode.com/problems/first-bad-version/)

## Problem
- Given a list of versions `[1, 2, ..., n]`, after a certain version, all the versions are bad versions, find the first bad version.
- Use `boolean isBadVersion(int version)` to check which version is bad.

## Solutions
- Solution 1: Binary search
  ```java
  public int firstBadVersion(int n) {
      int left = 1;
      int right = n;
      while (left < right) {
          int mid = left + (right - left) / 2;
          if (isBadVersion(mid)) {
              right = mid;
          } else {
              left = mid + 1;
          }
      }
      return left;
  }
  ```
