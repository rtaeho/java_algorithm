/*
문제
Congratulations, you adopted some little puppies! Now you just need to go grab food for them at the store. Your vet tells you how many pounds of food each pup will eat before your next trip to the store, so you just need to calculate the total amount of food that you will need to buy. You also know how much food costs per pound, so you just need to make sure that you bring the right amount of money to pay for the food. Write a program that, given the number of puppies, the amount of food per puppy, and the price per pound of food, calculates the amount of money that you will need to bring.

입력
The first line will contain a single integer n that indicates the number of lines that follow. Each line will contain three non-negative numbers d, f, and p for the number of dogs, the amount of food per dog in pounds, and the price of the food per pound.

출력
For each data set, output the total amount of money required to buy the food, rounded to the nearest hundredth. Include a dollar sign before the number.

예제 입력 1
3
3 2 1
5 .16 4.54
3 3.7 3.6
예제 출력 1
$6.00
$3.63
$39.96
 */
package baekjoon.busyday.august;

import java.util.Scanner;

public class BOJ26575 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            double d = sc.nextDouble();
            double f = sc.nextDouble();
            double p = sc.nextDouble();

            String s = String.format("%.2f", d * f * p);
            System.out.print("$");
            System.out.println(s);
        }

    }
}
