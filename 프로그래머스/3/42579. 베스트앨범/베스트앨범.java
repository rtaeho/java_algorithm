import java.util.*;

class Song{
    int id;
    String genre;
    int plays;

    public Song(int id, String genre, int plays){
        this.id = id;
        this.genre = genre;
        this.plays = plays;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hm = new HashMap<>();
        PriorityQueue<Song> pq = new PriorityQueue<>((a, b) -> {               
            if(!hm.get(a.genre).equals(hm.get(b.genre))){                     
                return hm.get(b.genre) - hm.get(a.genre);                     
            }
            else{
                if(a.plays == b.plays){
                    return a.id - b.id;                                       
                }
                else{
                    return b.plays - a.plays;                                 
                }
            }
        });

        for(int i = 0; i < genres.length; i++){
            hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
        }

        for(int i = 0; i < genres.length; i++){
            pq.offer(new Song(i, genres[i], plays[i]));
        }

        int[] answer = new int[genres.length];
        int idx = 0;                                                           

        String gen = "";
        int cnt = 0;
        for(int i = 0; i < genres.length; i++){
            Song s = pq.poll();
            if(!gen.equals(s.genre)){                                         
                gen = s.genre;
                cnt = 0;
            }
            if(cnt >= 2){
                continue;
            }
            cnt++;
            answer[idx++] = s.id;                                             
        }
        return Arrays.copyOf(answer, idx);                                     
    }
}