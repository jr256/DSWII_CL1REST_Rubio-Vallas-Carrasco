package pe.edu.cibertec.DSWII_CL1REST_RubioVallasCarrasco.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.DSWII_CL1REST_RubioVallasCarrasco.model.MensajeResponse;
import pe.edu.cibertec.DSWII_CL1REST_RubioVallasCarrasco.service.EjerciciosService;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/ejercicios")
public class EjerciciosController {

    private EjerciciosService ejerciciosService;


    //Ejercicio préstamo
    @GetMapping("/prestamo")
    public ResponseEntity<MensajeResponse> cuotasPrestamo(@RequestParam double monto){

        return new ResponseEntity<>(
                ejerciciosService.calcularCuotas(monto), HttpStatus.OK);

    }


}
