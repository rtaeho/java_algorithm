import java.util.*;

class Solution {
    static class Song{
        int play;
        int idx;
        
        public Song(int play, int idx){
            this.play = play;
            this.idx = idx;
        }
    }
    static class Rank{
        int total;
        PriorityQueue<Song> pq;
        
        public Rank(){
            this.pq = new PriorityQueue<>((s1, s2) ->{
                if(s1.play == s2.play){
                    return Integer.compare(s1.idx, s2.idx);
                }
                return Integer.compare(s2.play, s1.play);
            });
            this.total = 0;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Rank> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            int playCnt = plays[i];
            Rank rank = map.getOrDefault(genre, new Rank());
            rank.total += playCnt;
            rank.pq.offer(new Song(playCnt, i));
            map.put(genre, rank);
        }
        List<Map.Entry<String, Rank>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> {
            return Integer.compare(o2.getValue().total, o1.getValue().total);
        });
        
        List<Integer> answerList = new LinkedList<>();
        int idx = 0;
        for(Map.Entry<String, Rank> entry : entryList){
            PriorityQueue<Song> songPQ = entry.getValue().pq;
            if(songPQ.size() > 1){
                answerList.add(songPQ.poll().idx);
            }
            answerList.add(songPQ.poll().idx);
        }
    
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}