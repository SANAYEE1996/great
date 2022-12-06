package com.best.great.shopping.service;

import java.util.Scanner;

public class FilterService {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("소인수분해 할 수를 입력하세요. : ");
        int num = sc.nextInt();
        int i=2;

        while(num>=i)
        {
            if(num%i==0)
            {
                System.out.print(i);
                num /= i;
            }
            else
            {
                i++;
            }
        }
    }
}
