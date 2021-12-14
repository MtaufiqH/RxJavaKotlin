# Learn RXJava with Kotlin

### Key Points:

###### Chapter 1: Introduction

- **RxJava** is library that provides an Rx framework for Java-based projects such us Android.
- **RxKotlin** library adds some kotlin related utilities and extension on top of RxJava.
- RxJava helps you build **Reactive system** in a declarative way.
- the main elements in RxJava are **Observables, Operators**, and **Schedulers**.
- RxAndroid and RxBinding libraries assist you in building Android 
applications with reactive programming.


###### Chapter 2: Observables

 - Everything in RxJava is a Sequence. and the primary sequence type **Observable**
 - Observable start emitting when they are **subscribed** to. 
 - we must **dispose** of subscription when done with them. 
and you'll often use a _CompositeDisposable_. 


There are three special types of **Observable** in RxJava:
1. _**Singles**_, will emit either success (value) or error event. success(values) is actually
   a combination of the next and completed events. this useful for one time processes.
2. _**Completable**_, will only emit a complete or error event, and it doesn't emit any value.
3. _**Maybe**_, combination from Single and Completable, will emit either success (values) or error event.

###### Chapter 3: Subjects

There are four types of **Subject** in RxJava:
1. _**PublishSubject**_, start empty and only emits new element to subscribers
2. _**BehaviorSubject**_, starts with an optional initial value and replay it to new subscribers
3. _**ReplaySubject**_, initialized with a buffer size and will maintain a buffer of elements 
up to that size and replay it to new subscribers
4. _**AsyncSubject**_, starts empty and only emits the last item it receives before it's completed to subscribers. 






