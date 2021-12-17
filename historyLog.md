# Learn RXJava with Kotlin

### Key Points:

##### Chapter 1: Introduction

- **RxJava** is library that provides an Rx framework for Java-based projects such us Android.
- **RxKotlin** library adds some kotlin related utilities and extension on top of RxJava.
- RxJava helps you build **Reactive system** in a declarative way.
- the main elements in RxJava are **Observables, Operators**, and **Schedulers**.
- RxAndroid and RxBinding libraries assist you in building Android 
applications with reactive programming.


##### Chapter 2: Observables

 - Everything in RxJava is a Sequence. and the primary sequence type **Observable**
 - Observable start emitting when they are **subscribed** to. 
 - we must **dispose** of subscription when done with them. 
and you'll often use a _CompositeDisposable_. 


There are three special types of **Observable** in RxJava:
1. _**Singles**_, will emit either success (value) or error event. success(values) is actually
   a combination of the next and completed events. this useful for one time processes.
2. _**Completable**_, will only emit a complete or error event, and it doesn't emit any value.
3. _**Maybe**_, combination from Single and Completable, will emit either success (values) or error event.

##### Chapter 3: Subjects
- Subject are observable that are also **Observer**.
- PublishSubject is used when you only want to receive events that occur after you've subscribed.
- BehaviourSubject will relay the latest event that has occurred when you susbcribe, including
  an optional initial value.
- ReplaySubject will buffer a configurable number of events that get replayed to new subscribers.
  you must watch out for buffering too much data in a ReplaySubject.
- AsyncSubject only sends subscribers the most recent next event upon a complete event occuring.
- The [RxRelay](https://github.com/JakeWharton/RxRelay) library can be used with relays in place of subjects.
  to prevent accidental complete and error events to be sent.

There are four types of **Subject** in RxJava:
1. _**PublishSubject**_, start empty and only emits new element to subscribers
2. _**BehaviorSubject**_, starts with an optional initial value and replay it to new subscribers
3. _**ReplaySubject**_, initialized with a buffer size and will maintain a buffer of elements 
up to that size and replay it to new subscribers
4. _**AsyncSubject**_, starts empty and only emits the last item it receives before it's completed to subscribers.

##### Chapter 4:  Operators

###### Filtering Operator
- **Ignoring** operators like ignoreElements, elementAt, and filter let you remove 
certain element from an Observable stream. 
- **Skipping** operators let you skip certain element and then begin emitting. 
- Conversely, **taking** operators let you take certain element and then stop emitting. 
- **Distinct** operators let your prevent duplicates from being emitted back-to-back in 
an Observable stream.

###### Transforming Operator
- **Transforming** operator let you transform observable items from their original type to a new type.
- we can use **toList** to turn a normal observable into an observable that emits a single list. 
- the **map** operator will transform individual elements in an observable to some other value or type.
- we can use **flatMap** to flatten an observable stream of observables into one stream of items. 
- **SwitchMap** will also flatten a stream of observables, but this time only listening to the observable in the source that has most recently emitted an item.
- we use **Materialize** to make observables emit notification of events rather than the events themselves. and **Dematerialize** to transform from notifications 
type back to the original type. 






