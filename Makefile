.PHONY: build test run clean

build:
	mvn -B -DskipTests package

test:
	mvn -B test

run: build
	java -jar target/estructuras-algoritmos-0.1.0-SNAPSHOT.jar

clean:
	mvn -B clean
