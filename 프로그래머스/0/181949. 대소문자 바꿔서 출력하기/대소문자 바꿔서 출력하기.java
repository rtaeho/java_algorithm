import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String a = sc.next();
        
        for(char c : a.toCharArray()){
            
            if('A' <= c && c <= 'Z'){
                sb.append(Character.toLowerCase(c)); 
            }
            else{
                sb.append(Character.toUpperCase(c));
            }
        }
        
        System.out.print(sb.toString());
        
        sc.close();
    }
}