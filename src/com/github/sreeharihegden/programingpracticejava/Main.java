package com.github.sreeharihegden.programingpracticejava;

public class Main {

    public static void main(String[] args){
        helloWorld.printHelloWorld();
        demoStack();
    }

    public static void demoStack(){
        System.out.println("\n************");
        System.out.println("In demoStack");
        System.out.println("************");
        Stack s = new Stack();

        s.push(50);
        s.push(60);
        s.push(70);

        s.display();

        s.pop();
        s.pop();

        s.display();
    }
}
