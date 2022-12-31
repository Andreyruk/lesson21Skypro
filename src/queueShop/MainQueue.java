package queueShop;

import queueShop.QueueShop;

import java.util.*;

public class MainQueue {
    public static void main(String... args) {
        System.out.println("Домашнее задание 21-2.");
        System.out.println();

        int limitQueue = 5;
        int queueCount = 4;
        int peopleCount = 100;

        List<String> people = generatePeople(peopleCount);

        people.forEach(item -> System.out.println(item));

//        QueueShop queueShop1 = new QueueShop("очередь1");
//        QueueShop queueShop2 = new QueueShop("очередь2");
//        QueueShop queueShop3 = new QueueShop("очередь3");
        List<QueueShop> queueShopList = generateQueueShop(queueCount);
        if (queueShopList.size() > 0) {
            QueueShop[] queueShops = queueShopList.toArray(new QueueShop[queueCount]);
            addPeopleToQueue(people, limitQueue, queueShops);
            removePersonFromQueue(queueShops);
            queueShopList.forEach(item -> System.out.println(item.getNameQueue() + " - " + item.getQueue().size() + " чел."));
        }


    }

    public static List<QueueShop> generateQueueShop(int sizeList) {
        List<QueueShop> list = new ArrayList<>();
        for (int i = 1; i <= sizeList; i++) {
            list.add(new QueueShop("очередь" + i));
        }

        return list;
    }

    public static List<String> generatePeople(int sizeList) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= sizeList; i++) {
            list.add("Person " + i);
        }

        return list;
    }

    public static void addPeopleToQueue(List<String> people, int limitQueue, QueueShop... queues) {
        for (String person : people) {
            QueueShop queueShop = findMinQueue(limitQueue, queues);
            if (queueShop.addPersonToQueue(person, limitQueue)) {
                System.out.println(String.format("%s добавился в %s размер очереди %s", person, queueShop.getNameQueue(), queueShop.getQueue().size()));
            } else {
                System.out.println("Позвать Галю");
                break;
            }

//            Arrays.stream(queues).forEach(queue -> {
//                if (queue.getQueue().size() < limitQueue) {
//                    queue.addPersonToQueue(person,limitQueue);
//                }
//            });
        }

    }

    public static QueueShop findMinQueue(int limitQueue, QueueShop... queues) {
        int min = queues[0].getQueue().size();
        int indexQueue = 0;

        for (int i = 1; i < queues.length; i++) {
            if (queues[i].getQueue().size() < min && queues[i].getQueue().size() < limitQueue) {
                min = queues[i].getQueue().size();
                indexQueue = i;
            }
        }
        return queues[indexQueue];
    }

    public static void removePersonFromQueue(QueueShop... queues) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(queues.length);
        queues[randomIndex].getQueue().poll();
    }
}
