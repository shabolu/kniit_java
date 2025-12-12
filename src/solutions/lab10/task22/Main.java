package solutions.lab10.task22;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Dictionary<K, V> {
    
    private class Entry {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry> entries = new ArrayList<>();

    public void put(K key, V value) {
        for (Entry entry : entries) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        entries.add(new Entry(key, value));
    }

    public V get(K key) {
        for (Entry entry : entries) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        Iterator<Entry> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.key.equals(key)) {
                iterator.remove();
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Dictionary {");
        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            sb.append(entry.key).append("=").append(entry.value);
            if (i < entries.size() - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();

        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);
        dictionary.put("Charlie", 35);
        
        System.out.println("После добавления: " + dictionary);

        System.out.println("Возраст Alice: " + dictionary.get("Alice")); // 25
        System.out.println("Возраст Unknown: " + dictionary.get("Unknown")); // null

        dictionary.put("Bob", 31);
        System.out.println("Обновленный Bob: " + dictionary.get("Bob")); // 31

        dictionary.remove("Charlie");
        System.out.println("После удаления Charlie: " + dictionary);
    }
}