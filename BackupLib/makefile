#user make -n <target> to generate the command, then run the command.

junitlib=D:/apache-maven-3.2.2/m2/repository/junit/junit/4.8.2/junit-4.8.2.jar
ojdbclib=D:/apache-maven-3.2.2/m2/repository/com/oracle/ojdbc14/10.2.0.3.0/ojdbc14-10.2.0.3.0.jar
classpath=$(junitlib);$(ojdbclib);target/classes;target/test-classes


compile: clean
	-mkdir target
	-mkdir target\classes
	-mkdir target\test-classes
	cp src/main/resources/* target/classes/
	javac -cp $(classpath) -d target/classes/ src/main/java/ck/db/*.java

compile-test:
	javac -cp $(classpath) -d target/test-classes/ src/test/java/ck/db/*.java

test:
	java -cp $(classpath) org.junit.runner.JUnitCore ck.db.DBConfigTest ck.db.DBConnectTest

clean:
	-rm -rf target
