package eu.getmangos.controllers;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;

import eu.getmangos.entities.DbVersion;

@RequestScoped
public class DbVersionController {
    @Inject private Logger logger;

    @PersistenceContext(unitName = "AUTH_PU")
    private EntityManager emAuth;

    @PersistenceContext(unitName = "CHAR_PU")
    private EntityManager emChar;

    @PersistenceContext(unitName = "WORLD_PU")
    private EntityManager emWorld;

    /**
     * Retrieves the database version.
     * @return A record containing the database version.
     */
    public DbVersion getAuthDBVersion() {
        logger.debug("getAuthDBVersion() entry.");

        DbVersion version = (DbVersion) emAuth.createNamedQuery("DbVersion.findAll").getSingleResult();

        logger.debug("getAuthDBVersion() exit.");
        return version;
    }

    /**
     * Retrieves the database version.
     * @return A record containing the database version.
     */
    public DbVersion getCharDBVersion() {
        logger.debug("getCharDBVersion() entry.");

        DbVersion version = (DbVersion) emChar.createNamedQuery("DbVersion.findAll").getSingleResult();

        logger.debug("getCharDBVersion() exit.");
        return version;
    }

    /**
     * Retrieves the database version.
     * @return A record containing the database version.
     */
    @SuppressWarnings("unchecked")
    public List<DbVersion> getWorldDBVersion() {
        logger.debug("getWorldDBVersion() entry.");

        List<DbVersion> list = emWorld.createNamedQuery("DbVersion.findAll").getResultList();

        logger.debug("getWorldDBVersion() exit.");
        return list;
    }
}