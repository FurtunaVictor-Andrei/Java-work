import java.util.Objects;

public class Masina extends Vehicul
{

    public String firma;
    public String model;
    private int an;

    public Motor motor;


    public Masina() {

        super();
        motor = new Motor();
        System.out.println( super.merg());
        System.out.println("Constructor");
        this.motor.capCilindrica =10;
    }

    public Masina(int an) //Constructor default
    {
        super("Autovehicul");
        motor = new Motor();
        this.an=an;
    }
    public Masina(String model, int an){
        this.an=an;
        this.model=model;
    }

    public Masina(int an, String model, String firma) {
        this.an = an;
        this.model = model;
        this.firma = firma;
    }

    public void set_an(int an)
    {
        this.an=an;
    }

    public int get_an()
    {
        return an;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setModel(String model, int operatie)//supraincarcare
    {
        this.model = model;
        this.an +=operatie/100;
    }

    @Override //suprascriere
    public String toString() {
        return "model='" + model + '\'' +
                ", an=" + an + ", tip= " + this.tip;
    }
    @Override
    public String merg()
    {
        return "Eu merg pe roti";
    }

    public int compara(Masina m)
    {
        if(this.an==m.an)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Masina masina = (Masina) o;
        return an == masina.an && Objects.equals(firma, masina.firma) && Objects.equals(model, masina.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firma, model, an);
    }
}
