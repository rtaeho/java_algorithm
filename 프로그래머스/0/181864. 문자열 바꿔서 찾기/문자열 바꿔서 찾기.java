class Solution {
    public int solution(String myString, String pat) {
        String changedString = myString.replace('A', 'C').replace('B', 'A').replace('C', 'B');
        return changedString.contains(pat) ? 1 : 0;
    }
}