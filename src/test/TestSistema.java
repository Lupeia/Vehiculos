package test;

import modelo.Sistema;
import modelo.Vehiculo;
import java.util.List;

public class TestSistema {

    public static void main (String args[]) {

        //El atributo eficienciaMotor de la clase Vehículo tendrá un valor entre 0.1 y 0.9 (Pueden
        //agregar validación y excepción para controlar ese dato).


        Sistema sist = new Sistema();

       try {

            sist.agregarAuto("Hyundai", "Cronos", 2014, 4, 0.3, 4);

            sist.agregarMoto("Kawasaki", "Naked", 2020, 2, 0.5, true, false);
            sist.agregarMoto("Triumph", "Scooter", 2000, 2, 0.6, false, true);
            sist.agregarMoto("Suzuki", "Touring", 1980, 2, 0.8, true, true);
            sist.agregarAuto("Chevrolet", "Renault", 2010, 4, 0.2, 4);
            sist.agregarAuto("Ford", "Ranger", 2004, 4, 0.4, 4);
            sist.getListasVehiculos().forEach(System.out::println);
            //System.out.println(sist.getListasVehiculos().get(0));

            //System.out.println(sist.toString());
       } catch (Exception e) {
            System.out.println(e);
       }


        System.out.println("El vehiculo traido es: " + sist.traerVehiculo("Suzuki", "Touring"));
        System.out.println("El vehiculo traido es: " + sist.traerVehiculo("Chevrolet", "Renault"));

        System.out.println("El consumo es: " + sist.traerVehiculo("Chevrolet", "Renault").calcularConsumo(15));
        System.out.println("El consumo es: " + sist.traerVehiculo("Kawasaki", "Naked").calcularConsumo(60));
        System.out.println("El consumo es: " + sist.traerVehiculo("Triumph", "Scooter").calcularConsumo(20));
        System.out.println("El consumo es: " + sist.traerVehiculo("Suzuki", "Touring").calcularConsumo(50));

        System.out.println("Los años de antiguedad del vehiculo son: " + sist.traerVehiculo("Triumph", "Scooter").aniosAntiguedad() + " años");

        List<Vehiculo> transporte = sist.traerVehiculosDeTransporte();

        System.out.println("Los vehiculos que son de transporte son: " + transporte.toString());

        List<Vehiculo> consumo = sist.traerVehiculosPorConsumo(15, 0.8);

        System.out.println("Los vehiculos que respetan el consumo son: " + consumo.toString());

    }



}
