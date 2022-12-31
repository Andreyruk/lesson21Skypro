package task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> biDemArrList = new ArrayList<>();
        int chess = 0;
        for (int i = 0; i < 8; i++) {
            biDemArrList.add(i, new ArrayList<>());

            for (int j = 0; j < 8; j++) {
                biDemArrList.get(i).add(j, chess);
                if (biDemArrList.get(i).size() < 8) {
                    if (chess == 0) {
                        chess = 1;
                    } else {
                        chess = 0;
                    }
                }
                System.out.print(biDemArrList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                System.out.print(biDemArrList.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
        List<List<String>> strDemArrList = new ArrayList<>();
        String str = "x";
        for (int i = 0; i < 8; i++) {
            strDemArrList.add(i, new ArrayList<>());

            for (int j = 0; j < 8; j++) {
                strDemArrList.get(i).add(j, str);
                if (strDemArrList.get(i).size() < 8) {
                    if (str == "x") {
                        str = "o";
                    } else {
                        str = "x";
                    }
                }
                System.out.print(strDemArrList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
