package com.github.sreeharihegden.programingpracticejava;

import java.util.*;

public class Student{
    public int age;
    public String fname;

    public Student(String fname, int age){
        this.fname = fname;
        this.age = age;
    }

    public String toString(){
        return("{" + this.fname + ", " + this.age + "}");
    }

    public static int compareByNameThenAge(Student s1, Student s2) {
        if(s1.fname.equals(s2.fname))
            return s1.age-s2.age;
        else
            return s1.fname.compareTo(s2.fname);
    }

    public static class MyComparator implements Comparator<Student>{
        @Override
        public int compare(Student s1, Student s2) {
            if(s1.fname.equals(s2.fname))
                return s1.age-s2.age;
            else
                return s1.fname.compareTo(s2.fname);
        }
    }
}


