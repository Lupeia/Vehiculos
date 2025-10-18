package modelo;

public class Moto extends Vehiculo {

    private boolean incluyeCaja;
    private boolean diseñoAerodinamico;

    public Moto(int id, String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor, boolean incluyeCaja, boolean diseñoAerodinamico) throws Exception{
        super(id, marca, modelo, anio, cantRuedas, eficienciaMotor);
        this.incluyeCaja = incluyeCaja;
        this.diseñoAerodinamico = diseñoAerodinamico;
    }

    public boolean isIncluyeCaja() {
        return incluyeCaja;
    }

    public void setIncluyeCaja(boolean incluyeCaja) {
        this.incluyeCaja = incluyeCaja;
    }

    public boolean isDiseñoAerodinamico() {
        return diseñoAerodinamico;
    }

    public void setDiseñoAerodinamico(boolean diseñoAerodinamico) {
        this.diseñoAerodinamico = diseñoAerodinamico;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Moto moto = (Moto) o;
        return incluyeCaja == moto.incluyeCaja && diseñoAerodinamico == moto.diseñoAerodinamico;
    }

    @Override
    public String toString() {
        return "Moto{" + super.toString() + "\n" +
                "incluyeCaja=" + incluyeCaja + "\n" +
                " diseñoAerodinamico=" + diseñoAerodinamico;
    }

    public double calcularConsumo(int km){

        double eficienciaAjustada = eficienciaMotor;

        if(isIncluyeCaja()){
            eficienciaAjustada += 0.03;
        }

        if(diseñoAerodinamico){
            eficienciaAjustada -= 0.05;
        }

        return km * eficienciaAjustada;

    }





}
