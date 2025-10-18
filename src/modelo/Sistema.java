package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sistema {

  private List<Vehiculo> listasVehiculos;

    public Sistema() {
        this.listasVehiculos = new ArrayList<>();
    }

    public List<Vehiculo> getListasVehiculos() {
        return listasVehiculos;
    }

    public void setListasVehiculos(List<Vehiculo> listasVehiculos) {
        this.listasVehiculos = listasVehiculos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sistema sistema = (Sistema) o;
        return Objects.equals(listasVehiculos, sistema.listasVehiculos);
    }

    @Override
    public String toString() {
        String resultado = "Sistema: \n";
          for(Vehiculo v: listasVehiculos){

              resultado += v.toString() + "\n\n";

          }

        return resultado;
    }

    public Vehiculo traerVehiculo (String marca, String modelo){

        int indice = 0;
        boolean encontrado = false;
        Vehiculo buscado = null;

        while (indice < listasVehiculos.size() && !encontrado){


            if(listasVehiculos.get(indice).getMarca().equalsIgnoreCase(marca) && listasVehiculos.get(indice).getModelo().equalsIgnoreCase(modelo)) {

                buscado = listasVehiculos.get(indice);
                encontrado = true;

            }

            indice++;
        }

        return buscado;
    }


    public boolean agregarAuto(String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor, int cantPuertas) throws Exception{

        int id = 1;

    if(listasVehiculos.size() > 0){

        id = listasVehiculos.get(listasVehiculos.size()-1).getId()+1;
    }

    return listasVehiculos.add(new Auto(id, marca, modelo, anio, cantRuedas, eficienciaMotor,cantPuertas));
     }

     public boolean agregarMoto(String marca, String modelo, int anio, int cantRuedas, double eficienciaMotor, boolean incluyeCaja, boolean disenioAerodinamico) throws Exception {

        int id = 1;

        if(listasVehiculos.size() > 0){

            id = listasVehiculos.get(listasVehiculos.size()-1).getId()+1;

        }

     return  listasVehiculos.add(new Moto(id, marca, modelo, anio, cantRuedas, eficienciaMotor,incluyeCaja, disenioAerodinamico));
     }

    public List <Vehiculo> traerVehiculosDeTransporte(){

        List<Vehiculo> vehiculosTrasporte = new ArrayList<>();

        for(Vehiculo v: listasVehiculos){

            if(v instanceof Auto) {

                vehiculosTrasporte.add(v);

            }else if(v instanceof Moto) {
                if(((Moto) v).isIncluyeCaja()){

                 vehiculosTrasporte.add(v);
                }

            }


        }

        return vehiculosTrasporte;
    }

    public List<Vehiculo> traerVehiculosPorConsumo (int km, double topeConsumo){

        List<Vehiculo> vehiculosConsumo = new ArrayList<>();

        for (Vehiculo v: listasVehiculos){

            if(v instanceof Auto){

                if(v.calcularConsumo(km) < topeConsumo){

                    vehiculosConsumo.add(v);
                }
            }

            if (v instanceof Moto) {

                if(((Moto) v).calcularConsumo(km) < topeConsumo) {

                    vehiculosConsumo.add(v);
                }
            }

        }

        return vehiculosConsumo;
    }













}
