package co.com.claro.imeiBloqueo.model;

import co.com.claro.imeiBloqueo.entity.Imeibloqueo;
import java.util.List;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DataResponse {

    @Getter
    @Setter
    private GenericResponse response;

    @Getter
    @Setter
    private List<Imeibloqueo> imeiBloqueo;

}
