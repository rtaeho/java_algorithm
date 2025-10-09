class Solution {
    public int[] solution(int[][] edges) {
        // 숫자가 연속되어 있다는 보장 X
        // 나가는 게 두 개 이상이고 들어오는 게 없으면 생성한 정점
        // 두 개의 정점에서 들어오고 두 개의 정점으로 나가면 8자 중심
        // 나가는 게 없으면 막대 끝
        // 전체에서 두 개 제외한 게 도넛
        
        int[] inDegree = new int[1000001];
        int[] outDegree = new int[1000001];
        
        // 간선 정보로 차수 계산
        for(int[] edge : edges){
            int from = edge[0];
            int to = edge[1];
            outDegree[from]++;  // from에서 나감
            inDegree[to]++;     // to로 들어옴
        }
        
        int createdNode = 0;
        int stick = 0;
        int eight = 0;
        
        // 모든 정점 확인
        for(int i = 1; i <= 1000000; i++){
            // 생성 정점: 진입=0, 진출>=2
            if(inDegree[i] == 0 && outDegree[i] >= 2){
                createdNode = i;
            }
            // 막대 끝: 진입>0, 진출=0
            else if(inDegree[i] > 0 && outDegree[i] == 0){
                stick++;
            }
            // 8자 중심: 진입>=2, 진출=2
            else if(inDegree[i] >= 2 && outDegree[i] == 2){
                eight++;
            }
        }
        
        // 도넛 = 전체 - 막대 - 8자
        int totalGraphs = outDegree[createdNode];
        int donut = totalGraphs - stick - eight;
        
        return new int[]{createdNode, donut, stick, eight};
    }
}