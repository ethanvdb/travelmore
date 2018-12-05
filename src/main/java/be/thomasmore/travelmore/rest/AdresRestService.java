package be.thomasmore.travelmore.rest;

import be.thomasmore.travelmore.domain.Adres;
import be.thomasmore.travelmore.service.AdresService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Lorenz on 9/11/2018.
 */
@Path("/adressen")
public class AdresRestService{

    @Inject
    private AdresService adresService;

    @GET
    @Path("/getadres")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })

    public List<Adres> getAllAdressen() {
        return adresService.findAllAdressen();
    }

    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public  Response deleteAdres(@PathParam("id") int id, @HeaderParam("Authorization") String auth) {

        if(null ==  adresService.findAdresById(id)){
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Adres you provided is not found on our system").build();
        }
        if (!auth.equals("admin")){
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("You are not authorized to delete something").build();
        }
        adresService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).entity("Adres deleted").build();
    }


    @POST
    @Path("/addadres")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addAdres(Adres adres) {
        if (null != adresService.findAdresById(adres.getId())) {
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .entity("adres id should not be set.").build();
        }

        adresService.insert(adres);
        return Response.status(Response.Status.CREATED).entity(adres).build();
    }
}
