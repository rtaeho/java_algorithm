class Solution {
    public int solution(int[] date1, int[] date2) {
        int dateValue1 = date1[0] * 10000 + date1[1] * 100 + date1[2];
        int dateValue2 = date2[0] * 10000 + date2[1] * 100 + date2[2];

        return dateValue1 < dateValue2 ? 1 : 0;
    }
}