# Java Remote Method Invocation usage example

## Introduction to RMI
The RMI (Remote Method Invocation) is an API that provides a mechanism to create distributed application in Java.
RMI (Remote Method Invocation) is a way that a programmer, using the Java programming language and development environment, can write object-oriented programming in which objects on different computers can interact in a distributed network.

### General
- Client-server systems usage
- Enables delivery of data between 2 and more different applications (usually client-server)
- Uses TCP

### The classic low-level model
- TCP connections using sockets
- Stream or object writing/reading

### The RMI model
- Client calls methods on the Server
- Object Oriented
- Over TCP implementation, makes developer use methods, not low-level sockets and data management

### What it looks and feels like
`client calls some object's method -> server's method gets invoked`
```java
/*------------------*/
/*    FEELS LIKE    */
/*------------------*/
class Server {
  someMethod() {}
}

class Client {
  Server obj = new Server();
  obj.someMethod();
}
```

### What it actually does
`client calls proxy's method -> proxy -> tcp -> rmi layer -> server's method gets invoked`
```java
/*------------------*/
/*   ACKCHYUALLY    */
/*------------------*/
...
```

## Architecture
- Remote Object
  - The server on which the methods will be invoked
  - Exports and implements interface (list of methods) for further remote invokations
  - And... that's it, you are good to go, without any sockets or data transportation management
- RMI Registry
  - Comes with standard Java Development Kit installation
  - Receives interface and connection details from the Remote
  - Usualy located in the same computer with the Remote
- Client
  - Receives Remote reference/proxy from RMI Registry (object that implements the interface over the
  network)
  - Calls methods that are implemented in that object

## How does it actually work
- Server implements a remote interface
- Stub and skeleton being compiled
  - The stub (client side) hides the serialization of parameters and the network-level communication
  in order to present a simple invocation mechanism to the caller
  - The skeleton (server side) is responsible for dispatching the call to the actual remote object
  implementation
- Server binds methods in the RMI registry
- RMI registry publishes proxy
- Client looks up and receives proxy
- Client calls methods of the proxy
- The proxy implements and invokes method on the Remote
- The RMI layer on the Remote listens and receives the invocation and calls the relevant method of
the Remote Object 
- The RMI layer returns a response to the Client
