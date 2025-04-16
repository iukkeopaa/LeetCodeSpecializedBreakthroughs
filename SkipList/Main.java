import java.util.Random;

class SkipList<T extends Comparable<T>> {
    private static final int MAX_LEVEL = 32;
    private static final double PROBABILITY = 0.5;
    private Node<T> head;
    private int level;
    private Random random;

    public SkipList() {
        head = new Node<>(null, MAX_LEVEL);
        level = 0;
        random = new Random();
    }

    private class Node<U extends Comparable<U>> {
        U value;
        Node<U>[] forward;

        public Node(U value, int level) {
            this.value = value;
            forward = new Node[level + 1];
        }
    }

    private int randomLevel() {
        int lvl = 0;
        while (random.nextDouble() < PROBABILITY && lvl < MAX_LEVEL) {
            lvl++;
        }
        return lvl;
    }

    public void insert(T value) {
        Node<T>[] update = new Node[MAX_LEVEL + 1];
        Node<T> current = head;
        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value.compareTo(value) < 0) {
                current = current.forward[i];
            }
            update[i] = current;
        }
        current = current.forward[0];
        if (current == null || !current.value.equals(value)) {
            int newLevel = randomLevel();
            if (newLevel > level) {
                for (int i = level + 1; i <= newLevel; i++) {
                    update[i] = head;
                }
                level = newLevel;
            }
            Node<T> newNode = new Node<>(value, newLevel);
            for (int i = 0; i <= newLevel; i++) {
                newNode.forward[i] = update[i].forward[i];
                update[i].forward[i] = newNode;
            }
        }
    }

    public boolean delete(T value) {
        Node<T>[] update = new Node[MAX_LEVEL + 1];
        Node<T> current = head;
        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value.compareTo(value) < 0) {
                current = current.forward[i];
            }
            update[i] = current;
        }
        current = current.forward[0];
        if (current != null && current.value.equals(value)) {
            for (int i = 0; i <= level; i++) {
                if (update[i].forward[i] != current) {
                    break;
                }
                update[i].forward[i] = current.forward[i];
            }
            while (level > 0 && head.forward[level] == null) {
                level--;
            }
            return true;
        }
        return false;
    }

    public boolean contains(T value) {
        Node<T> current = head;
        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value.compareTo(value) < 0) {
                current = current.forward[i];
            }
        }
        current = current.forward[0];
        return current != null && current.value.equals(value);
    }

    public void printList() {
        for (int i = level; i >= 0; i--) {
            Node<T> current = head.forward[i];
            System.out.print("Level " + i + ": ");
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.forward[i];
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();
        skipList.insert(3);
        skipList.insert(6);
        skipList.insert(7);
        skipList.insert(9);
        skipList.insert(12);
        skipList.insert(19);
        skipList.insert(17);
        skipList.insert(26);
        skipList.insert(21);
        skipList.insert(25);
        skipList.printList();
        System.out.println("Contains 19: " + skipList.contains(19));
        skipList.delete(19);
        System.out.println("Contains 19: " + skipList.contains(19));
    }
}    