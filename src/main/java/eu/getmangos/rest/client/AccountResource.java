package eu.getmangos.rest.client;

import java.util.Date;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "accountClient")
@RegisterProvider(UnknownUriExceptionMapper.class)
@Path("/v1")
public interface AccountResource {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAccount(@PathParam("id") Integer id) throws UnknownUriException, ProcessingException;

    @GET
    @Path("bans")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllBans();

    @DELETE
    @Path("bans/{id}/{bandate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBan(@PathParam("id") Integer id, @PathParam("bandate") Date banDate);

    @GET
    @Path("warden")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllWardenLogs();

    @DELETE
    @Path("warden")
    @Produces(MediaType.APPLICATION_JSON)
    public Response cleanupWardenLogs();
}
