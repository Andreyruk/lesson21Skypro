package queueShop;

import java.util.LinkedList;
import java.util.Queue;

public class QueueShop {
    private String nameQueue;
    private Queue<String> queue = new LinkedList<>();

    public QueueShop(String nameQueue) {
        this.nameQueue = nameQueue;
    }

    public boolean addPersonToQueue(String person, int limitQueue) {
        if (queue.size() < limitQueue) {
            queue.offer(person);
            return true;
        }
        return false;
    }

    public Queue<String> getQueue() {
        return queue;
    }

    public String getNameQueue() {
        return nameQueue;
    }
}
