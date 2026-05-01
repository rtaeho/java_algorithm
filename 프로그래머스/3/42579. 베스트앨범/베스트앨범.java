import java.util.*;

class Solution {
    static class Song {
        int id;
        int play;

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genrePlayCount = new HashMap<>();
        HashMap<String, List<Song>> genreMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            
            if (!genreMap.containsKey(genres[i])) {
                genreMap.put(genres[i], new ArrayList<>());
            }
            genreMap.get(genres[i]).add(new Song(i, plays[i]));
        }

        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        Collections.sort(sortedGenres, new Comparator<String>() {
            @Override
            public int compare(String g1, String g2) {
                return genrePlayCount.get(g2) - genrePlayCount.get(g1);
            }
        });

        List<Integer> bestAlbumList = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<Song> songs = genreMap.get(genre);
            
            Collections.sort(songs, new Comparator<Song>() {
                @Override
                public int compare(Song s1, Song s2) {
                    if (s1.play == s2.play) {
                        return s1.id - s2.id;
                    }
                    return s2.play - s1.play;
                }
            });

            bestAlbumList.add(songs.get(0).id);
            if (songs.size() > 1) {
                bestAlbumList.add(songs.get(1).id);
            }
        }

        int[] answer = new int[bestAlbumList.size()];
        for (int i = 0; i < bestAlbumList.size(); i++) {
            answer[i] = bestAlbumList.get(i);
        }

        return answer;
    }
}