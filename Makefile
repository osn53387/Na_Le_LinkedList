cl:
	javac -d bin main/csci2720/p1/ItemType.java
	javac -cp bin -d bin main/csci2720/p1/NodeType.java
	javac -cp bin -d bin main/csci2720/p1/SortedLinkedList.java
	javac -cp bin -d bin main/csci2720/p1/LinkedListDriver.java
run: cl
	java -cp bin csci2720.p1.LinkedListDriver
clean:
	rm -rf bin/csci2720/p1/ItemType.class
	rm -rf bin/csci2720/p1/NodeType.class
	rm -rf bin/csci2720/p1/SortedLinkedList.class
	rm -rf bin/csci2720/p1/LinkedListDriver.class
