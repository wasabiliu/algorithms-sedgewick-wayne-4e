1.1.10

What is wrong with the following code fragment?
```java
int [] a;
for (int i=0; i < 10; i++)
    a[i] = i * i;
```

It doesn't allocate memory for `a[]` with `new`. This code results in a
variable a might not have been initialized compile-time error.
Correct one:
```java
int [] a = new int[10];
for (int i=0; i < 10; i++)
    a[i] = i * i;
```