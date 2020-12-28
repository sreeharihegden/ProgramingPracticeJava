package com.github.sreeharihegden.codesharepracticejava;

import java.util.List;

public class MissingNumberInArray {
    public static int findMissing(List<Integer> input){
        int actSum = 0;
        for(Integer n:input)
            actSum += n;

        int numIntegers = input.size() + 1; // n + 1 integers counting the wrong number.
        int expSum = (numIntegers * (numIntegers+1))/2;

        return expSum - actSum;
    }
}
