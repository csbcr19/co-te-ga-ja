import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Map<Integer, Integer>> songs = new HashMap<>();
        Map<String, Integer> genrePlays = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();
        
        for(int i = 0; i < plays.length; i++){
            String genre = genres[i];
            int play = plays[i];
            
            if(!songs.containsKey(genre)){
                songs.put(genre, new HashMap<>());
            }
            songs.get(genre).put(i, play);
            genrePlays.put(genre, genrePlays.getOrDefault(genre, 0) + play);
        }

        List<String> sortedGenre = new ArrayList<>(genrePlays.keySet());
        Collections.sort(sortedGenre, (a, b) -> genrePlays.get(b) - genrePlays.get(a));
        
        for(String genre : sortedGenre){
            List<Map.Entry<Integer, Integer>> sortedSongs = new ArrayList<>(songs.get(genre).entrySet());
            Collections.sort(sortedSongs, (a, b) -> b.getValue() - a.getValue());
            
            int count = 0;
            for(Map.Entry<Integer, Integer> entry : sortedSongs) {
                answerList.add(entry.getKey());
                count++;
                if(count == 2){
                    break;
                }
            }
        }
        
        int answer[] = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
        
    }
}