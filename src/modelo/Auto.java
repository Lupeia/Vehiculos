package modelo;

public class Auto extends Vehiculo{

    private int cantPuertas;

    public Auto(int id, String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor, int cantPuertas) throws Exception{
        super(id, marca, modelo, anio, cantRuedas, eficienciaMotor);
        this.cantPuertas = cantPuertas;
    }

    public int getCantPuertas() {
        return cantPuertas;
    }

    public void setCantPuertas(int cantPuertas) {
        this.cantPuertas = cantPuertas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Auto auto = (Auto) o;
        return cantPuertas == auto.cantPuertas;
    }

    @Override
    public String toString() {
        return "Auto{" + super.toString() + "\n" +
                "cantPuertas= " + cantPuertas;
    }






}
