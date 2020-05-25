docker rmi $(docker images --filter "dangling=true" -q --no-trunc) 2>/dev/null

docker run --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp openjdk:11.0.6-slim-buster javac Main.java

docker run --rm -v "$PWD":/usr/src/myapp -w /usr/src/myapp openjdk:11.0.6-slim-buster java Main
