package eu.getmangos.rest.client;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "realmClient")
@RegisterProvider(UnknownUriExceptionMapper.class)
@Path("/v1")
public interface RealmResource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRealm(@PathParam("id") Integer id);

    @GET
    @Path("link")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllRealmCharacters();

    @DELETE
    @Path("link/realm/{realmID}/account/{accountID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRealmCharacters(@PathParam("accountID") Integer accountID, @PathParam("realmID") Integer realmID);

    @GET
    @Path("status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUptimes();

}
