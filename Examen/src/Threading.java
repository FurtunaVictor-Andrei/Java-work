import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Threading implements Runnable{
    public ArrayList<HpcJob> listaThread= new ArrayList<>();
    public int contortotal=0;


    @Override
    public void run() {
        listaThread=citireFisier("src/examen2.csv");

    }
//public int contorTotal(int contor)
//{
//    int contortotal=contor;
//    return contortotal;
//}
    public ArrayList<HpcJob> citireFisier(String nume_fisier)
    {
        ArrayList<HpcJob> lista = new ArrayList<>();
        //int contortotal=0;
        this.contortotal=0;
        try {
            FileReader fr = new FileReader("src/examen9.csv");
            BufferedReader br = new BufferedReader(fr);
            String split = "[,]";
            String line = br.readLine();

            while ((line=br.readLine()) != null)
            {
                this.contortotal++;
                try {
                    HpcJob job = new HpcJob();
                    String[] spliter = line.split(split);
                    job.setJobId(spliter[0].trim());
                    job.setUser(spliter[1].trim());
                    job.setQueue(spliter[2].trim());
                    job.setNodesUsed(Integer.parseInt(spliter[3].trim()));
                    job.setDurationMin(Integer.parseInt(spliter[4].trim()));
                    job.setCpuHours(Integer.parseInt(spliter[5].trim()));
                    job.setStatus(spliter[6].trim());
                    lista.add(job);
                } catch (Exception e) {
                    System.out.println("Eroare de parsare");

                    //e.printStackTrace();

                }
            }

        } catch(Exception e)
        {
            e.printStackTrace();
        }
        return lista;

    }
}
