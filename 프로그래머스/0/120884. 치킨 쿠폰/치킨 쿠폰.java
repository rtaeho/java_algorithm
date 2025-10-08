class Solution {
    public int solution(int chicken) {
        int service = -1;
        while(chicken > 0){
            chicken-=10;
            service++;
            chicken++;
        }
        service = service < 0 ? 0 : service;
        return service;
    }
}