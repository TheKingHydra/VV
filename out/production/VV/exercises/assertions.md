# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer


1. This assertion fails because the value of "3*.4" isn't exactly "1.2" but more like "1.2000000002". This is the result of a problem with the representation of floats in Java (but also in the other languages). This type of check should be done using `assertEquals` instead of `assertTrue`

2. ``assertEquals`` returns true if the two elements are of the same value, while ``assertSame``returns true only if it is the same element, i.e. using ``assertEquals`` with two elements of the same value would return true but `assertSame` would not.
```java
Integer i1 = new Integer(1);
Integer i2 = new Integer(1);
assertEquals(i1, i2); // => True
assertSame(i1, i2); // => False
assertSame(i1, i1); // => True
```

3. `fail` can be used to verify that a certain portion of the code is never used. For example, a default case in a switch or match that should not be used, or when catching an exception.

4. ``assertThrows`` allows you to verify that the exception is correctly thrown, and you can check its attributes .It allows you to verify that it is thrown using the right parameters