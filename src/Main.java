import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String[]> dictionary = new HashMap<>();
        dictionary.put("большой", new String[]{"огромный", "громадный", "великий", "колосальный"});
        dictionary.put("человек", new String[]{"персона", "миледи", "личность", "гражданин"});
        dictionary.put("красивый", new String[]{"привлекательный", "обоятельный", "симпатичный", "прекрасный", "приятный"});
        dictionary.put("дом", new String[]{"квартира", "жилище", "вилла", "комуналка", "хата", "особняк"});

        HashMap<String, String[]> bigDictionary = new HashMap<>();
        Set<String> keyWords = dictionary.keySet();
        Iterator iterator = keyWords.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String[] word = dictionary.get(key);
            bigDictionary.put(key, word);
            for (int i = 0; i < word.length; i++) {
                String newKey = word[i];
                ArrayList<String> newWords = new ArrayList<>();
                newWords.addAll(Arrays.asList(word));
                newWords.remove(newKey);
                newWords.add(key);
                String[] arrayConverter;
                arrayConverter = newWords.toArray(new String[0]);
                bigDictionary.put(newKey, arrayConverter);


            }
        }


        System.out.println("Введите любое слово из словаря:");
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        for (int i = 0; i < words.length; i++) {
            String[] synonyms = bigDictionary.get(words[i]);
            if (synonyms != null) {
                Random random = new Random();
                int randomIndex = random.nextInt(synonyms.length);
                System.out.print(synonyms[randomIndex] + " ");
            } else {
                System.out.print("Слово не найдено ");
            }
        }

    }
}
