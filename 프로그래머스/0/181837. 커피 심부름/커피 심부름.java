class Solution {
    public int solution(String[] order) {
        int totalPayment = 0;
        
        for (String menu : order) {
            if (menu.contains("cafelatte")) {
                totalPayment += 5000;
            } 
            else {
                totalPayment += 4500;
            }
        }
        
        return totalPayment;
    }
}