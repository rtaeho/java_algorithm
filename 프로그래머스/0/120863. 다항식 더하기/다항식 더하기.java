class Solution {
    public String solution(String polynomial) {
        String[] str = polynomial.split(" ");
        StringBuilder sb = new StringBuilder();        
        int sumX = 0;
        int sum = 0;
        
        for(int i = 0; i < str.length; i++){
            if(str[i].equals("+")) {
                continue;
            }
            
            if(str[i].contains("x")){
                if(str[i].equals("x")) {
                    sumX += 1;
                } else {
                    sumX += Integer.parseInt(str[i].replace("x", ""));
                }
            } else {
                sum += Integer.parseInt(str[i]);
            }
        }
        
        if(sumX > 0) {
            if(sumX == 1) {
                sb.append("x");
            } else {
                sb.append(sumX).append("x");
            }
        }
        
        if(sum > 0) {
            if(sb.length() > 0) {
                sb.append(" + ");
            }
            sb.append(sum);
        }
        return sb.toString();
    }
}