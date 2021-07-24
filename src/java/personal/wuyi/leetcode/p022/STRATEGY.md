## Strategy

The solution for n can be separated into 2 cases
- Add the "(" and ")" at the both ends of the each result from *n-1*
```
XXX -> (XXX)
```

- n can be separated into 2 parts: a + b = n, so the result of *a* and result of *b* can be left combine or right combine
```
resultListA = generateParenthesis(a);
resultListB = generateParenthesis(b);
for (resultA : resultListA) {
    for (resultB : resultListB) {
        resultA + resultB
        resultB + resultA
    }
}
```

For example, if n = 5,  the combination can be (1, 4), (2, 3), (3, 2), (4, 1)
