package modelo;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Vehiculo {

    protected int id;
    protected String marca;
    protected String modelo;
    protected int anio;
    protected int cantRuedas;
    protected double eficienciaMotor;

    public Vehiculo(int id, String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor) throws Exception {

        this.setEficienciaMotor(eficienciaMotor);
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.cantRuedas = cantRuedas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantRuedas() {
        return cantRuedas;
    }

    public void setCantRuedas(int cantRuedas) {
        this.cantRuedas = cantRuedas;
    }

    public double getEficienciaMotor() {
        return eficienciaMotor;
    }

    public void setEficienciaMotor(double eficienciaMotor) throws Exception{

        if(eficienciaMotor < 0.1 && eficienciaMotor > 0.9){

            throw new Exception("La eficiencia del motor debe estar entre 0.1 y 0.9");
        }
        this.eficienciaMotor = eficienciaMotor;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return id == vehiculo.id && anio == vehiculo.anio && cantRuedas == vehiculo.cantRuedas && Double.compare(eficienciaMotor, vehiculo.eficienciaMotor) == 0 && Objects.equals(marca, vehiculo.marca) && Objects.equals(modelo, vehiculo.modelo);
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", cantRuedas=" + cantRuedas +
                ", eficienciaMotor=" + eficienciaMotor +
                '}';
    }

   public int aniosAntiguedad(){

       int anioActual = LocalDate.now().getYear();

       int antiguedad = anioActual - anio;

       return antiguedad;
   }

    public double calcularConsumo(int km){

        return km * eficienciaMotor;

    }










}
