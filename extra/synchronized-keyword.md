# synchronized keyword

The ```synchronized``` keyword is used when multi-threaded programs come to a situation where multiple threads try to access the same resources and finally produce erroneous and unforeseen results. Java provides a way of creating threads and synchronizing their task by using synchronized blocks. Synchronized blocks in Java are marked with the ```synchronized``` keyword. A synchronized block in Java is synchronized on some object. All synchronized blocks synchronized on the same object can only have one thread executing inside them at a time. All other threads attempting to enter the synchronized block are blocked until the thread inside the synchronized block exits the block.  

Following is the general form of a synchronized block:  

```
// Only one thread can execute at a time. 
// sync_object is a reference to an object
// whose lock associates with the monitor. 
// The code is said to be synchronized on
// the monitor object
synchronized(sync_object)
{
   // Access shared variables and other
   // shared resources
}
```

This synchronization is implemented in Java with a concept called monitors. Only one thread can own a monitor at a given time. When a thread acquires a lock, it is said to have entered the monitor. All other threads attempting to enter the locked monitor will be suspended until the first thread exits the monitor.   

Following is an example of multi threading with synchronized.

```java
// A Java program to demonstrate working of
// synchronized.
import java.io.*;
import java.util.*;

// A Class used to send a message
class Sender
{
	public void send(String msg)
	{
		System.out.println("Sending\t" + msg );
		try
		{
			Thread.sleep(1000);
		}
		catch (Exception e)
		{
			System.out.println("Thread interrupted.");
		}
		System.out.println("\n" + msg + "Sent");
	}
}

// Class for send a message using Threads
class ThreadedSend extends Thread
{
	private String msg;
	Sender sender;

	// Receives a message object and a string
	// message to be sent
	ThreadedSend(String m, Sender obj)
	{
		msg = m;
		sender = obj;
	}

	public void run()
	{
		// Only one thread can send a message
		// at a time.
		synchronized(sender)
		{
			// synchronizing the snd object
			sender.send(msg);
		}
	}
}

// Driver class
class SyncDemo
{
	public static void main(String args[])
	{
		Sender snd = new Sender();
		ThreadedSend S1 =
			new ThreadedSend( " Hi " , snd );
		ThreadedSend S2 =
			new ThreadedSend( " Bye " , snd );

		// Start two threads of ThreadedSend type
		S1.start();
		S2.start();

		// wait for threads to end
		try
		{
			S1.join();
			S2.join();
		}
		catch(Exception e)
		{
			System.out.println("Interrupted.");
		}
	}
}

```

The output is same every time we run the above program.

When we invoke the join() method on a thread, the calling thread goes into a waiting state. It remains in a waiting state until the referenced thread terminates.  


### References
- [Synchronized in Java - GFG](https://www.geeksforgeeks.org/synchronized-in-java/)