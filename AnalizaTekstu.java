package pzj_wykla2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class AnalizaTekstu {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new File("SuplatowiczStanislawZiemiaSlonychSkal.txt"));
        Scanner sk = new Scanner(new File("stop_words.txt"));

        ArrayList<String> listaWyrazow = new ArrayList<>();
        ArrayList<String> listaK = new ArrayList<>();

        while (sc.hasNext()) {
            String wyraz = sc.next().toLowerCase().replaceAll("[^A-Za-zżźćńółęąśŻŹĆĄŚĘŁÓŃ0-9]", "");
            if (!wyraz.isEmpty()) {
                listaWyrazow.add(wyraz);
            }
        }

        while (sk.hasNext()) {
            String wyraz = sk.next();
            if (!wyraz.isEmpty()) {
                listaK.add(wyraz);
            }
        }

        /* 
        
        for (String s : listaWyrazow) {
            System.out.println(s);
        }        
         
        HashSet<String> zbiorWyrazow = new HashSet<>();
        
        for (String s : listaWyrazow) {
            zbiorWyrazow.add(s);
        }
        
        i=1;
        
        for (String s : zbiorWyrazow) {
            System.out.println(i+" "+s);
            i++;
        }
        
        
        
         */
        HashMap<String, Integer> slownikWyrazow = new HashMap<>();
        HashMap<String, Integer> slownikWyrazow2 = new HashMap<>();
        for (String s : listaWyrazow) {
            slownikWyrazow.compute(s, (key, value) -> value == null ? 1 : value + 1);
        }
        slownikWyrazow2 = (HashMap) slownikWyrazow.clone();

        for (String s : listaK) {
            if (slownikWyrazow2.containsKey(s)) {
                slownikWyrazow2.remove(s);
            }
        }

        ArrayList<Slowo> listaSlow = new ArrayList<>();
        ArrayList<Slowo> listaSlow2 = new ArrayList<>();

        Set<Entry<String, Integer>> entrySet = slownikWyrazow.entrySet();
        for (Entry<String, Integer> entry : entrySet) {
            listaSlow.add(new Slowo(entry.getKey(), entry.getValue()));
        }
        Set<Entry<String, Integer>> entrySet2 = slownikWyrazow2.entrySet();
        for (Entry<String, Integer> entry : entrySet2) {
            listaSlow2.add(new Slowo(entry.getKey(), entry.getValue()));
        }

        Collections.sort(listaSlow);
        Collections.sort(listaSlow2);

        for (int z = 0; z < 20; z++) {
            System.out.println(listaSlow.get(z));
        }
        System.out.println("-------------");
        for (int z = 0; z < 20; z++) {
            System.out.println(listaSlow2.get(z));
        }

    }

    
}
