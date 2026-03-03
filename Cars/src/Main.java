public class Main {

    public static void main(String[] args) {

        Masina masina; //declaratia obiectului
        masina = new Masina(); // instantierea obiectului
        masina.set_an(2008);
        masina.firma="Dacia";
        masina.model="Logan";

        masina.set_an(2010);
        System.out.println(masina.get_an());
        Masina masina2 = new Masina(2022);
        Masina masina3 = new Masina("Tico", 2025);
        Masina masina4 = new Masina("Tico", 2025);
        masina3.tip = "autovehocul";
        System.out.println(masina3.merg());

        System.out.println(masina3);

        if(masina3.equals(masina4))
        {
            System.out.println("Masinile sunt egale");
        }
    }
}
