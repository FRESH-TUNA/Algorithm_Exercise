app.out: main.o linkedList.o node.o
	gcc -o app.out main.o linkedList.o node.o
 
main.o: linkedList.h main.c
	gcc -c -o main.o main.c
 
linkedList.o: linkedList.h node.h type.h linkedList.c
	gcc -c -o linkedList.o linkedList.c
 
node.o: node.h type.h node.c
	gcc -c -o node.o node.c
