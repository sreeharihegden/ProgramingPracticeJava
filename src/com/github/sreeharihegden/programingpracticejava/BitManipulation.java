package com.github.sreeharihegden.programingpracticejava;

public class BitManipulation {
    public void and(int n1, int n2){
        // System.out.println("Bitwise AND: " + n1 + ", " + n2 + " = " + String.format("%8s", Integer.toBinaryString(n1 & n2).replace(' ', '0')));
        System.out.println("Bitwise AND: " + n1 + ", " + n2 + " = "
                + Integer.toBinaryString(n1) + " & "
                + Integer.toBinaryString(n2) + " = "
                + Integer.toBinaryString(n1 & n2));
    }

    public void or(int n1, int n2){
        System.out.println("Bitwise OR: " + n1 + ", " + n2 + " = "
                + Integer.toBinaryString(n1) + " | "
                + Integer.toBinaryString(n2) + " = "
                + Integer.toBinaryString(n1 | n2));
    }

    public void exclusiveor(int n1, int n2){
        System.out.println("Bitwise XOR: " + n1 + ", " + n2 + " = "
                + Integer.toBinaryString(n1) + " ^ "
                + Integer.toBinaryString(n2) + " = "
                + Integer.toBinaryString(n1 ^ n2));
    }

    public void leftshift(int n1, int n2){
        System.out.println("Bitwise Leftshift: " + n1 + ", " + n2 + " = "
                + Integer.toBinaryString(n1) + " << "
                + Integer.toString(n2) + " = "
                + Integer.toBinaryString(n1 << n2));
    }

    public void rightshift(Integer n1, Integer n2){
        System.out.println("Bitwise Rightshift: " + n1 + ", " + n2 + " = "
                + Integer.toBinaryString(n1) + " >> "
                + Integer.toString(n2) + " = "
                + Integer.toBinaryString(n1 >> n2));
    }

    public void complement(Integer n1){
        System.out.println("Bitwise Complement: " + n1 + " = "
                + Integer.toBinaryString(n1) + " ~ " + " = "
                + Integer.toBinaryString(~n1));
    }

    public void checkKthBitSet(Integer n1, int k){
        int result = n1 & (1 << k - 1);
        boolean b = (result != 0);
        System.out.println("Bitwise Check " + k + "th Bit Set or Not in: " + n1 + " = "
                + Integer.toBinaryString(n1) + " & (1 << " + k + "-1) " + " = "
                + b);
    }

    public void setKthBit(Integer n1, int k){
        System.out.println("Bitwise Set " + k + "th Bit in: " + n1 + " = "
                + Integer.toBinaryString(n1) + " | (1 << " + k + "-1) " + " = "
                + Integer.toBinaryString(n1 | (1 << k-1)));
    }

    public void clearKthBit(Integer n1, int k){
        System.out.println("Bitwise Clear " + k + "th Bit in: " + n1 + " = "
                + Integer.toBinaryString(n1) + " & ~ (1 << " + k + "-1) " + " = "
                + Integer.toBinaryString(n1 &~ (1 << k-1)));
    }

    public void toggleKthBit(Integer n1, int k){
        System.out.println("Bitwise Toggle " + k + "th Bit in: " + n1 + " = "
                + Integer.toBinaryString(n1) + " ~ (1 << " + k + "-1) " + " = "
                + Integer.toBinaryString(n1 ^ (1 << k-1)));
    }

    public void toggleRightmostOneBit(Integer n1){
        System.out.println("Bitwise Toggle Rightmost One Bit: " + n1 + " = "
                + Integer.toBinaryString(n1) + " & (" + n1 + "-1) " + " = "
                + Integer.toBinaryString(n1 & (n1-1)));
    }

    public void isolateRightmostOneBit(Integer n1){
        System.out.println("Bitwise Isolate Rightmost One Bit: " + n1 + " = "
                + Integer.toBinaryString(n1) + " & -" + n1 + " = "
                + Integer.toBinaryString(n1 & -n1));
    }

    public void isolateRightmostZeroBit(Integer n1){
        Integer n2 = n1;
        System.out.println("Bitwise Isolate Rightmost Zero Bit: " + n1 + " = "
                + "~" + Integer.toBinaryString(n1) + " & -" + n1 + " + 1 = "
                + Integer.toBinaryString(~n2 & (n1+1)));
    }

    public void isPowerOf2(int n1){
        boolean result = false;
        if((n1 & (n1-1)) == 0)
            result = true;
        else
            result = false;

        System.out.println("Bitwise Is Power of 2: " + n1 + " = "
                + "if(" + Integer.toBinaryString(n1) + " & " + Integer.toBinaryString(n1-1) + ") == 0 = "
                + result);
    }

    public void multiplyByPowerOf2(int n1, int n2){
        System.out.println("Bitwise Multiply " + n1 + " by " + n2 + " nd Power of 2: = "
                + Integer.toBinaryString(n1) + " << " + n2 + " = "
                + (n1 << n2));
    }

    public void divideByPowerOf2(int n1, int n2){
        System.out.println("Bitwise Divide " + n1 + " by " + n2 + " nd Power of 2: = "
                + Integer.toBinaryString(n1) + " >> " + n2 + " = "
                + (n1 >> n2));
    }

    public void isEven(int n1){
        boolean result = ((n1&1)!=1) ? true:false;
        System.out.println("Bitwise is Even using &: " + n1 + " = "
                + "if(" + Integer.toBinaryString(n1) + " & " + Integer.toBinaryString(1) + ")!= 1 = "
                + result);
    }

}
