package co.com.claro.imeiBloqueo.model;

import co.com.claro.imeiBloqueo.entity.Imeibloqueo;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement(name = "DataResponse")
public class DataResponse {

    @Getter
    @Setter
    @XmlElement(required = true)
    private GenericResponse response;

    @Getter
    @Setter
    @XmlElement(required = true)
    private List<Imeibloqueo> imeiBloqueo;

}
