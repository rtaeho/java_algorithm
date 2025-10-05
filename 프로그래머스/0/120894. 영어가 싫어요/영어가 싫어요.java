class Solution {
    public long solution(String numbers) {
        String[] digitWords = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numbers.length(); ) {
            for (int j = 0; j < digitWords.length; j++) {
                String w = digitWords[j];
                if (numbers.startsWith(w, i)) {
                    sb.append(j);
                    i += w.length();
                    break;
                }
            }
        }
        
        return Long.parseLong(sb.toString());
    }
}