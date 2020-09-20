package com.github.sreeharihegden.programingpracticejava;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        helloWorld.printHelloWorld();

        demoStack();

        demoStackBalancedExpression();
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

    public static void demoStackBalancedExpression(){
        System.out.println("\n*****************************");
        System.out.println("In demoStackBalancedExpression");
        System.out.println("******************************");

        List<String> expressionList = new ArrayList<>();
        expressionList.add("1+2)");
        expressionList.add("(1+2)");
        expressionList.add("(");
        expressionList.add(")1+2(");
        expressionList.add("((1+2)");
        expressionList.add("(1+2>");

        for(String exp : expressionList){
            System.out.println(exp + " " + StackBalancedExpression.isBalanced(exp));
        }
    }
}
