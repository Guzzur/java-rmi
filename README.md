# Java Remote Method Invocation usage example

## Introduction to RMI
- General
  - Client-server systems usage
  - Enables delivery of data between 2 and more different applications (usually client-server)
  - Uses TCP
- The classic low-level model
  - TCP connections using sockets
  - Stream or object writing/reading
- The RMI model
  - Client calls methods on the Server
  - Object Oriented
  - Over TCP implementation, makes developer use methods, not low-level sockets and data management

## Architecture
- Remote Object
  - The server on which the methods will be invoked
  - Exports and implements interface (list of methods) for further remote invokations
  - And... that's it, you are good to go, without any sockets or data transportation management
- RMI Registry
  - Comes with standard Java Development Kit installation
  - Receives interface and connection details from Remote Object
- Client
  - Receives Remote reference/proxy from RMI Registry (object that implements the interface over the
  network)
  - Calls methods that are implemented in that object

## How does it actually work
1. test
2. test
