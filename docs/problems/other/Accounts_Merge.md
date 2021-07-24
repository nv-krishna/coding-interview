# Accounts Merge

## Alias
- Leetcode (721): [Accounts Merge](https://leetcode.com/problems/accounts-merge/)

## Problem
- Given a list of accounts where each element `accounts[i]` is a list of strings.
   - The first element of `accounts[i]` is the name.
   - The rest elements of `accounts[i]` are the emails.
- Merge all the accounts which belongs to the same person.
   - 2 accounts belongs to the same person if there are some common emails existing in both accounts.
- Additional requirements
   - For each account, emails should be sorted in alphabetical order.
   - For each account, remove duplicated emails to keep each email unique.

## Solutions
- Solution 1: Brute force
   - Step 1: Check every 2 account combinations by 2 brute force pointers
      - If 2 accounts have same emails
         - Merge the 1st account's emails to the 2nd account.
         - Remove the 1st account.
   - Step 2: For each account
      - Unify the emails of the account.
      - Sort the emails of the account.

  ```java
  public List<List<String>> accountsMerge(List<List<String>> accounts) {        
      for (int i = 0; i < accounts.size() - 1; i++)  {
          for (int j = i + 1; j < accounts.size(); j++) {
              if (accounts.get(i).get(0).equals(accounts.get(j).get(0))) {
                  if (hasSameEmail(accounts.get(i), accounts.get(j))) {      // If 2 accounts have same emails
                       mergeAccounts(accounts.get(j), accounts.get(i));      // Merge the 1st account's to the 2nd account
                       accounts.remove(i);                                   // Remove the 1st account
                       i--;                                                  // Don't increase the i value
                       break;
                  }
              }
          }
      }
        
      for (int i = 0; i < accounts.size(); i++) {
          if (!accounts.get(i).get(0).equals(" ")) {
              List<String> list = accounts.get(i).stream().distinct().collect(Collectors.toList()); // Remove the duplicates in the account
              Collections.sort(list.subList(1,list.size()));
              accounts.set(i, list);
          }
      }
        
      return  accounts;
  }
    
  public boolean hasSameEmail(List<String> account1, List<String> account2) {   
      return !Collections.disjoint(account1.subList(1,account1.size()), account2.subList(1,account2.size()));
  }
    
  public void mergeAccounts(List<String> account1, List<String> account2) {
      account1.addAll(account2.subList(1,account2.size()));
  }
  ```
