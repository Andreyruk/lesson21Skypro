package transport;

import transport.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static transport.enums.BodyType.*;
import static transport.enums.BusCapacity.*;
import static transport.enums.LiftCapacity.*;
import static transport.enums.TranportTypes.*;

public class MainTransport {
    private static Car[] auto;
    private static Truck[] trucks;
    private static Bus[] buses;

    public static void main(String[] args) throws IOException {
        System.out.println("Домашнее задание 21-1 и 2.");
        System.out.println();
        car();
        truck();
        buses();
        Car currentCar = auto[0];
        Bus currentBus = buses[0];
        Truck currentTruck = trucks[1];
        System.out.println("Очередь в станции обслуживания");
        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addToQueueAuto(auto[0]);
        serviceStation.addToQueueAuto(buses[0]);
        serviceStation.addToQueueAuto(trucks[1]);
        serviceStation.addToQueueAuto(auto[1]);
        //int sizeQueue = serviceStation.getQueue().size();
//        while (serviceStation.getQueue().size() != 0) {
//            serviceStation.doImaginationCar();
//         //   sizeQueue = serviceStation.getQueue().size();
//        }
        while (serviceStation.doImaginationCar()) {
        }
        //System.out.println(serviceStation.getQueue());
        System.out.println();

        Mechanic mechanic1 = new Mechanic("Alex", "BMW", addToList(auto[0], trucks[0]));
        Mechanic mechanic2 = new Mechanic("Tom", "Kia", addToList(auto[1], buses[1]));
        Sponsor sponsor1 = new Sponsor("Jhon", 1000.0, addToList(auto[0], buses[0], auto[3]));
        Sponsor sponsor2 = new Sponsor("Jhon", 2000.0, addToList(auto[1], trucks[1], auto[4]));
        Driver driver1 = new Driver("Ivan", 5.0, B);
        infoAuto(currentCar, driver1, addToList(mechanic1, mechanic2), addToList(sponsor1));
        Driver driver2 = new Driver("Stepan", 6.0, D);
        infoAuto(currentTruck, driver2, addToList(mechanic2), addToList(sponsor2, sponsor1));
        Driver driver3 = new Driver("Fedor", -6.0, null);
        infoAuto(currentBus, driver3, addToList(mechanic1), addToList(sponsor2));
    }

    public static <T> List<T> addToList(T... item) {
        List<T> list = new ArrayList<>();
//        Arrays.stream(car).forEach(item -> {
//            cars.add(item);
        Arrays.stream(item).forEach(list::add);
        return list;
    }

    public static <T extends Transport> void infoAuto(T auto, Driver driver, List<Mechanic> mechanic, List<Sponsor> sponsor) {
        System.out.println(driver);
        System.out.println(auto);
        if (driver.startMoving(auto.getType())) {
            System.out.println(String.format("водитель %s участвует в гонках", driver.getName()));
            auto.startMoving();
            auto.pitStop();
            auto.bestTime();
            auto.maxSpeed();
            driver.stopMoving();
            driver.refuelCar();
            auto.finishMoving();
        } else {
            System.out.println(String.format("водитель %s не может управлять транспортным средством типа %s", driver.getName(), auto.getType()));
        }
        auto.diagnostics();
        mechanic.forEach(System.out::println);
        sponsor.forEach(System.out::println);
//        System.out.println(mechanic);
//        System.out.println(sponsor);

        System.out.println();
    }

    public static void car() {
        auto = new Car[5];
        auto[0] = new Car("Lada", "Granta", -1.7, PICKUP, true);
        auto[1] = new Car("Audi", "A8 50 L TDI quattro", 3.0, SEDAN, true);
//        auto[2] = new transport.Car("BMW", "Z8", 3, "чёрный", "Германия");
        auto[3] = new Car("Kia", "Sportage 4-го поколения", 2.4, SUV, false);
        auto[4] = new Car("Hyundai", "Avante", -1.6, VAN, true);
        printInfoAuto(auto);
        System.out.println();
    }

    public static <T> void printInfoAuto(T[] auto) {
        for (T a : auto) {
            if (a != null) {
                System.out.println(a);
            }
        }
    }

    public static void truck() {
        trucks = new Truck[2];
        trucks[0] = new Truck("Камаз", "", 11.0, N1, true);
        trucks[1] = new Truck("МАЗ", "В-901", 11.0, N2, false);
        infoTruck();
        System.out.println();
    }

    public static void infoTruck() {
        for (Truck truck : trucks) {
            if (truck != null) {
                System.out.println(truck);
            }
        }
    }

    public static void buses() {
        buses = new Bus[2];
        buses[0] = new Bus("Ласточка", "В-901", 31.0, BIG, true);
        buses[1] = new Bus("Ленинград", /*"В-901"*/"", 31.0, SMALL, null);
        infoBus();
        System.out.println();
    }

    public static void infoBus() {
        for (Bus buses : buses) {
            if (buses != null) {
                System.out.println(buses);
            }
        }
    }
}