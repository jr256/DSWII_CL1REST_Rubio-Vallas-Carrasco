package pe.edu.cibertec.DSWII_CL1REST_RubioVallasCarrasco.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MensajeResponse {
    private String resultado;
}
