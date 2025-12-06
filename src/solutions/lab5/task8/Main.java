package solutions.lab5.task8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Книга", "Ручка", "Линейка", "Пенал", "Тетрадь", "Рюкзак"};
        double[] prices = {50.0, 150.0, 15.5, 300.0};
        int[] quantities = {1, 5, 10};

        ShopItem[] items = new ShopItem[100];
        Random random = new Random();

        for (int i = 0; i < items.length; i++) {
            String rndName = names[random.nextInt(names.length)];
            double rndPrice = prices[random.nextInt(prices.length)];
            int rndQty = quantities[random.nextInt(quantities.length)];
            
            items[i] = new ShopItem(rndName, rndPrice, rndQty);
        }

        Arrays.sort(items, new Comparator<ShopItem>() {
            @Override
            public int compare(ShopItem o1, ShopItem o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        System.out.println("--- Отсортированный список товаров (по цене) ---");
        for (ShopItem item : items) {
            System.out.println(item);
        }

        System.out.println("\n--- Статистика повторений ---");
        
        Map<ShopItem, Integer> counterMap = new HashMap<>();

        for (ShopItem item : items) {
            if (counterMap.containsKey(item)) {
                counterMap.put(item, counterMap.get(item) + 1);
            } else {
                counterMap.put(item, 1);
            }
        }

        int totalDuplicates = 0;
        for (Map.Entry<ShopItem, Integer> entry : counterMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " встретился " + entry.getValue() + " раз");
                totalDuplicates += (entry.getValue() - 1);
            }
        }
        
        System.out.println("Всего найдено " + (items.length - counterMap.size()) + " дубликатов");
        System.out.println("Уникальных товаров: " + counterMap.size());
    }
}