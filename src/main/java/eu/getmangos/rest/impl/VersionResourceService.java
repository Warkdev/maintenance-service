package eu.getmangos.rest.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.slf4j.Logger;

import eu.getmangos.controllers.DbVersionController;
import eu.getmangos.dto.DbVersionDTO;
import eu.getmangos.entities.DbVersion;
import eu.getmangos.mapper.VersionMapper;
import eu.getmangos.rest.VersionResource;

@RequestScoped
@Path("/version/v1")
@Tag(name = "version")
public class VersionResourceService implements VersionResource {

    @Inject private Logger logger;

    @Inject private DbVersionController dbVersionController;

    @Inject private VersionMapper mapper;

    @Override
    public Response getAuthDbVersion() {
        logger.debug("getAuthDbVersion() entry.");
        DbVersionDTO version = mapper.versionToDTO(dbVersionController.getAuthDBVersion());

        logger.debug("getAuthDbVersion() exit.");
        return Response.status(200).entity(version).build();
    }

    @Override
    public Response getCharDbVersion() {
        logger.debug("getCharDbVersion() entry.");
        DbVersionDTO version = mapper.versionToDTO(dbVersionController.getCharDBVersion());

        logger.debug("getCharDbVersion() exit.");
        return Response.status(200).entity(version).build();
    }

    @Override
    public Response getWorldDbVersion() {
        logger.debug("getWorldDbVersion() entry.");
        List<DbVersionDTO> list = new ArrayList<>();

        for(DbVersion v : dbVersionController.getWorldDBVersion()) {
            list.add(mapper.versionToDTO(v));
        }

        logger.debug("getWorldDbVersion() exit.");
        return Response.status(200).entity(list).build();
    }
}
