package co.com.claro.imeiBloqueo.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement (name = "GenericResponse")
public class GenericResponse {

    @Getter
    @Setter
    @XmlElement(required = true)
    private Boolean isValid;
    @Getter
    @Setter
    @XmlElement(required = true)
    private String description;

    public GenericResponse() {
    }

    public GenericResponse(Boolean isValid, String description) {
        this.isValid = isValid;
        this.description = description;
    }

}
