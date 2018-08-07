package spsolutions.springboot.microservices.demo.endpoint;

import spsolutions.springboot.microservices.demo.model.EntitiesDemo;
import spsolutions.springboot.microservices.demo.model.EntityDemo;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "users")
@Path("/entities")
public class EntityDemoEndpoint {
    private static Map<Integer, EntityDemo> DB = new HashMap<>();

    @GET
    @Produces("application/json,application/xml")
    public EntitiesDemo getAll() {
        EntitiesDemo entities = new EntitiesDemo();
        entities.setEntities(new ArrayList<>(DB.values()));
        return entities;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") int id) throws URISyntaxException {
        EntityDemo entity = DB.get(id);
        if (entity == null) {
            return Response.status(404).build();
        }
        return Response
                .status(200)
                .entity(entity)
                .contentLocation(new URI("/entities/" + id)).build();
    }

    @POST
    @Consumes("application/json")
    public Response create(EntityDemo entity) throws URISyntaxException {
        if (entity.getDescription() == null) {
            return Response.status(400).entity("Please provide all mandatory inputs").build();
        }
        entity.setId(DB.values().size() + 1);
        entity.setUri("/entities/" + entity.getId());
        DB.put(entity.getId(), entity);
        return Response.status(201).contentLocation(new URI(entity.getUri())).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id") int id, EntityDemo entity) throws URISyntaxException {
        System.out.println("Estoy en el UPDATE");
        EntityDemo temp = DB.get(id);
        if (temp == null) {
            return Response.status(404).build();
        }
        if (entity == null) {
            return Response.status(400).entity("Please provide all mandatory inputs").build();
        }
        temp.setDescription(entity.getDescription());
        DB.put(temp.getId(), temp);
        return Response.status(200).entity(temp).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) throws URISyntaxException {
        EntityDemo entity = DB.get(id);
        if (entity != null) {
            DB.remove(entity.getId());
            return Response.status(200).build();
        }
        return Response.status(404).build();
    }

    static {
        EntityDemo entity1 = new EntityDemo();
        entity1.setId(1);
        entity1.setDescription("Entidad 1");
        entity1.setUri("/entities/1");

        EntityDemo entity2 = new EntityDemo();
        entity2.setId(2);
        entity2.setDescription("Entidad 2");
        entity2.setUri("/entities/2");

        EntityDemo entity3 = new EntityDemo();
        entity3.setId(3);
        entity3.setDescription("Entidad 3");
        entity3.setUri("/entities/3");

        DB.put(entity1.getId(), entity1);
        DB.put(entity2.getId(), entity2);
        DB.put(entity3.getId(), entity3);
    }
}
