package spsolutions.springboot.microservices.demo.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="entity")
public class EntityDemo implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlAttribute(name="id")
    private int id;

    @XmlAttribute(name="description")
    private String description;

    @XmlAttribute(name="uri")
    private String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
