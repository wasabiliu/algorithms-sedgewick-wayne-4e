1.1.4

What (if anything) is wrong with each of the following statements?

a.
```java
if (a > b) then c = 0;
```

java doesn't have "then". The correct one is:
```java
if(a > b) c = 0;
```

b.
```java
if a > b { c = 0;}
```
`if` statement in java should have (), unlike golang.

c.
```java
if (a > b) c = 0;
```
No problem.

d.
```java
if (a > b) c = 0 else b = 0;
```
The correct one is:
```java
if (a > b) c = ; else b = 0;
```