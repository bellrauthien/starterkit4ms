package spsolutions.springboot.microservices.demo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "entities")
public class EntitiesDemo {
    @XmlElement(name="entity")
    private ArrayList<EntityDemo> entities;

    public ArrayList<EntityDemo> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<EntityDemo> entities) {
        this.entities = entities;
    }
}
