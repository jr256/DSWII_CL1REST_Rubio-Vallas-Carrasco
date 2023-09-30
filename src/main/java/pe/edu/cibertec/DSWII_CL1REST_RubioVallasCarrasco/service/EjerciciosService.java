package pe.edu.cibertec.DSWII_CL1REST_RubioVallasCarrasco.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL1REST_RubioVallasCarrasco.model.MensajeResponse;

import java.text.DecimalFormat;

@Service
public class EjerciciosService {


    // ******************Ejercicio prestamo************************
    public MensajeResponse calcularCuotas(double prestamo){

        if (prestamo < 1) {
           return MensajeResponse.builder()
                    .resultado("Monto de préstamo no puede ser menor a 1 ")
                    .build();
        }

        double interes = (prestamo < 4000) ? 0.12 : 0.10;
        double totalDeuda;
        int cuotas;

        if (prestamo > 5000) {
            totalDeuda = prestamo * (1 + interes);
            cuotas = 3;
        } else if (prestamo < 1000) {
            totalDeuda = prestamo * (1 + interes);
            cuotas = 1;
        } else if (prestamo >= 2000 && prestamo <= 3000) {
            totalDeuda = prestamo * (1 + interes);
            cuotas = 2;
        } else {
            totalDeuda = prestamo * (1 + interes);
            cuotas = 5;
        }

        double montoCuota = totalDeuda / cuotas;
        double tasaInteres = interes * 100;

        DecimalFormat df = new DecimalFormat("#.##");
        double montoCuotaDF = Double.parseDouble(df.format(montoCuota));
        double totalDeudaDF = Double.parseDouble(df.format(totalDeuda));

        return MensajeResponse.builder()
                .resultado(
                        "Cantidad cuotas: " + cuotas +
                        " , Monto cuota: " + montoCuotaDF +
                        " , Total deuda: " + totalDeudaDF +
                        " , Tasa de interés: " + tasaInteres+"%"

                )
                .build();
    }


    // ******************Ejercicio vocales************************

    public MensajeResponse mostrarVocal(int numero){

        if (numero < 1 || numero > 5) {
            return MensajeResponse.builder()
                    .resultado("Ingresar números de 1 al 5")
                    .build();
        }

        String vocal = switch (numero) {
            case 1 -> "A";
            case 2 -> "E";
            case 3 -> "I";
            case 4 -> "O";
            default -> "U";
        };

        return MensajeResponse.builder()
                .resultado(
                        "La vocal correspondiente al número " + numero +" es la letra " + vocal
                )
                .build();

    }
}
