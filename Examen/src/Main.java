import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Threading jobs = new Threading();
        Thread t1 = new Thread(jobs);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int contor=0;
        for (int i = 0; i < jobs.listaThread.size(); i++) {
            System.out.println(jobs.listaThread.get(i).toString());
            contor++;
        }
        System.out.println("Numar job-uri valide "+contor);
        System.out.println("Numar job-uri invalide "+ (jobs.contortotal-contor));

        HashMap<String, Integer> mapa = new HashMap<>();
        for (int i = 0; i < jobs.listaThread.size(); i++) {
            String numeUser = jobs.listaThread.get(i).getUser();
            if (mapa.containsKey(numeUser)) {
                Integer durataVeche = mapa.get(numeUser);
                mapa.put(numeUser, durataVeche + jobs.listaThread.get(i).getCpuHours());
            } else {
                mapa.put(numeUser, jobs.listaThread.get(i).getCpuHours());
            }
        }
        List<Map.Entry<String, Integer>> listaMap = new ArrayList<>(mapa.entrySet());
        for (int i = 0; i < listaMap.size(); i++) {
            System.out.println("Utilizatorul " + listaMap.get(i).getKey() + " foloseste " + listaMap.get(i).getValue() + " ore de cpu.");
        }
        HashMap<String, Integer> mapa2 = new HashMap<>();
        for (int i = 0; i < jobs.listaThread.size(); i++) {
            String coada = jobs.listaThread.get(i).getQueue();
            if (mapa.containsKey(coada)) {
                Integer durataVeche = mapa.get(coada);
                mapa2.put(coada, durataVeche + jobs.listaThread.get(i).getDurationMin());
            } else {
                mapa2.put(coada, jobs.listaThread.get(i).getDurationMin());
            }
        }
        List<Map.Entry<String, Integer>> listaMap2 = new ArrayList<>(mapa2.entrySet());
        for (int i = 0; i < listaMap2.size(); i++) {
            System.out.println("Job-ul din coada " + listaMap2.get(i).getKey() + " dureaza in medie " + listaMap2.get(i).getValue() / listaMap2.size());
        }

        HashMap<String, Integer> mapa3 = new HashMap<>();
        for (int i = 0; i < jobs.listaThread.size(); i++) {
            String job = jobs.listaThread.get(i).getJobId();
            mapa3.put(job, jobs.listaThread.get(i).getCpuHours());
        }

        List<Map.Entry<String, Integer>> listaMap3 = new ArrayList<>(mapa3.entrySet());

        for (int i = 0; i < listaMap3.size() - 1; i++) {
            int maxim = i;
            for (int j = i + 1; j < listaMap3.size(); j++) {
                if (listaMap3.get(j).getValue() > listaMap3.get(maxim).getValue()) {
                    maxim = j;
                }
            }
            Map.Entry<String, Integer> temp = listaMap3.get(i);
            listaMap3.set(i, listaMap3.get(maxim));
            listaMap3.set(maxim, temp);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(listaMap3.get(i).getKey());
        }
        HashMap<String, Integer> mapa4 = new HashMap<>();
        for (int i = 0; i < jobs.listaThread.size(); i++) {
            String job = jobs.listaThread.get(i).getJobId();
            mapa4.put(job, jobs.listaThread.get(i).getDurationMin());
        }
        List<Map.Entry<String, Integer>> listaMap4 = new ArrayList<>(mapa4.entrySet());
        for (int i = 0; i < listaMap4.size(); i++) {
            if(listaMap4.get(i).getValue() >= 500)
            {
                System.out.println("Job-ul "+listaMap4.get(i).getKey()+ " este lung");
            }
        }
    }
}
