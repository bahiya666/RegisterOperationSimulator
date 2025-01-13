Register Operations Simulator
This project simulates a register with read and write operations that occur at different times. The primary goal of the simulation is to determine all possible valid read sequences, respecting the order and constraints of previous write operations.

Features
Register Operations: The register supports two types of operations: WRITE and READ.
Time Constraints: Each operation is associated with a time interval (startTime and endTime).
Valid Read Sequences: The simulator calculates all valid read sequences, taking into account the previous write operations and their timing.

Components
1. Register Class
This class manages the list of operations (WRITE and READ). It:

  Records write and read operations.
  Calculates valid read values by considering the timings of write operations.
  Returns all valid read sequences through getValidReadValues().

2. RegisterOperation Class
This class represents an operation in the register. Each operation has:

  A type (WRITE or READ).
  A value for write operations.
  Start and end times for each operation.
  
3. Main Class
This class simulates various scenarios with different sequences of write and read operations. It demonstrates how valid read sequences are calculated for different combinations of operations.

4. Valid Read Sequence Calculation
The program evaluates all possible valid read sequences by checking:

  Whether a read operation can happen at a given time considering prior write operations.
  Whether the read operation respects the timing constraints.

Compile and run :

javac *.java
java Main

TESTING:
Each test scenario simulates different sequences of write and read operations:

Two Writes and Four Reads: Two write operations are performed, followed by four read operations. The valid read values are calculated considering the writes and their time intervals.
Back to Back Writes: This scenario has two consecutive write operations, and read operations are then performed afterward.
Non-Overlapping Reads: Reads occur at times that do not overlap with each other.
Complex Scenario: A more complex sequence with multiple writes and reads in different orders.
No Writes Scenario: This scenario contains only read operations, with no writes.
Multiple Consecutive Writes: Multiple write operations are executed consecutively, followed by a read.
Read Overlapping Multiple Writes: Reads occur while multiple write operations are being executed in the background.
Each valid read sequence considers the timing and order of previous writes.
