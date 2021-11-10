# volatile keyword

Using ```volatile``` keyword is yet another way like synchronized, atomic wrapper, etc., of making class thread-safe. Thread-safe means that a method or class instance can be used by multiple threads at the same time without any problem.  

In programming, an atomic action is one that effectively happens all at once. An atomic action cannot stop in the middle: it either happens completely, or it doesn't happen at all. No side effects of an atomic action are visible until the action is complete.

Consider below simple example.

```java
class SharedObj
{
   // Changes made to sharedVar in one thread
   // may not immediately reflect in other thread
   static int sharedVar = 6;
}
```

Suppose that two threads are working on ```SharedObj```. If two threads are running on two different processors, each thread may have its own local copy of ```sharedVar```. If one thread modifies its value, the change might not reflect in the original one in the main memory instantly. This depends on the "write policy" of cache. Now, the other thread is maybe not aware of the modified value which may lead to data inconsistency.  

Although, most modern hardware provide good cache coherence. Therefore, most probably, the changes in one cache are reflected in other but it’s not a good practice to rely on hardware for to ‘fix’ a faulty application.  

```java
class SharedObj
{
   // volatile keyword here makes sure that
   // the changes made in one thread are 
   // immediately reflect in other thread
   static volatile int sharedVar = 6;
}
```

## volatile vs synchronized

Before we move on let’s take a look at two important features of locks and synchronization. 

- **Mutual Exclusion**: It means that only one thread or process can execute a critical block of code at a time.
- **Visibility**: It means that changes made by one thread to any shared data are visible to other threads.

Java’s ```synchronized``` keyword guarantees both mutual exclusion and visibility. If we make the block of thread that modifies the value of shared variable synchronized, then, only one thread can enter the block and changes made by it will be reflected in the main memory. All other threads trying to enter the block at the same time will be blocked and put to sleep. 

In some cases we may only desire visibility and not atomicity. Use of ```synchronized``` in such situation is an overkill and may cause scalability problems. Here, ```volatile``` keyword comes to the rescue.  

Volatile variables have the visibility features of ```synchronized``` but not the atomicity features. The values of volatile variable will never be cached and all writes and reads will be done to and from the main memory. However, use of volatile is limited to the very restricted set of cases as most of the times atomicity is desired. For example, a simple increment statement such as x = x + 1; or x++ seems to be a single operation but is really a compound read-modify-write sequence of operations that must execute atomically. 

## volatile in Java vs C/C++

The ```volatile``` keyword in Java is different from “volatile” qualifier in C/C++. For Java, “volatile” tells the compiler that the value of a variable must never be cached as its value may change outside of the scope of the program itself. In C/C++, “volatile” is needed when developing embedded systems or device drivers, where you need to read or write a memory-mapped hardware device. The contents of a particular device register could change at any time, so you need the “volatile” keyword to ensure that such accesses aren’t optimized away by the compiler.

## References
- [volatile keyword in Java - GFG](https://www.geeksforgeeks.org/volatile-keyword-in-java/)