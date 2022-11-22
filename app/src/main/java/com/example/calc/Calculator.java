package com.example.calc;

import java.util.Arrays;
import java.util.Stack;

public class Calculator {

    static int textLimit = 100;

    static int currlen = 0;
    static private void countSigns(String text, int signpos[], char sign[], char csign)
    {
        for(int i = currlen; i < textLimit; i++) {
            int startPos = 0;
            if (i > 0)
            {
                if (sign[i - 1] == csign) {
                    startPos = signpos[i-1];
                }
            }
            int pos = text.indexOf(csign, startPos + 1);
            if (pos < 0) return;
            signpos[i] = pos;
            sign[i] = csign;
            currlen++;
        }
    }

    public static int find(int[] a, int target)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] == target) {
                return i;
            }
        }

        return -1;
    }

    static double correctDouble(String str)
    {
        if (str == "")
        {
            str = "0";
        }
        try {
            double num = Double.parseDouble(str);
            return num;
        }
        catch (Exception e)
        {
            return 0;
        }
    }


    static public double calc(String text)
    {
        double res = 0;
        int signpos[] = new int[textLimit];
        char sign[] = new char[textLimit];
        currlen = 0;

        //char csign = '+';
        countSigns(text, signpos,sign, '+');
        countSigns(text, signpos,sign, '-');
        countSigns(text, signpos,sign, '*');
        countSigns(text, signpos,sign, '/');

        if (currlen == 0)
        {
            res = correctDouble(text);
            return res;
        }

        int sortedSignPos[] = new int[currlen];
        System.arraycopy(signpos, 0, sortedSignPos, 0, currlen);
        Arrays.sort(sortedSignPos);


        String substr0 = text.substring(0, sortedSignPos[0]);
        double doubled = correctDouble(substr0);
        res += doubled;

        int textLen = text.length();

        for(int i = 0; i < currlen; i++)
        {
            int nextPos = textLen;
            if (i < currlen-1)
            {
                nextPos = sortedSignPos[i + 1];
            }
            String substr1 = text.substring(sortedSignPos[i] + 1, nextPos);

            double num = correctDouble(substr1);
            int signPosIndex = find(signpos, sortedSignPos[i]);
            if (signPosIndex >= 0)
            {
                char symb = sign[signPosIndex];
                if (symb == '+')
                {
                    res += num;
                }
                if (symb == '-')
                {
                    res -= num;
                }
                if (symb == '*')
                {
                    res *= num;
                }
                if (symb == '/')
                {
                    res /= num;
                }


            }

        }


        return res;
    }

}

