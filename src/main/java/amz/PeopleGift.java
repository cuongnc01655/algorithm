package amz;

import java.util.*;

public class PeopleGift {
    static class Person {
        String name;
        String gift;
        List<Person> friends;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return name.equals(person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {

    }

    private static Set<String> mostGifted(Person person, int topN) {
        Queue<Person> queue = new LinkedList<>();
        Set<Person> visited = new HashSet<>();
        Map<String, Integer> giftCount = new HashMap<>();
        queue.add(person);

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Person p = queue.poll();
                if (!visited.contains(p)) {
                    visited.add(p);
                    queue.addAll(p.friends);
                    giftCount.put(p.gift, giftCount.getOrDefault(p.gift, 0) + 1);
                }
            }
        }
//        now pivot giftCount and return
        Map<Integer, String> gift = new HashMap<>();

        return Collections.emptySet();
    }

}
