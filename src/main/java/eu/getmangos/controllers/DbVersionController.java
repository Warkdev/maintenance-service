package eu.getmangos.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;

import eu.getmangos.entities.DbVersion;

@RequestScoped
public class DbVersionController {
    @Inject private Logger logger;

    @PersistenceContext(name = "AUTH_PU")
    private EntityManager emAuth;

    @PersistenceContext(name = "CHAR_PU")
    private EntityManager emChar;

    @PersistenceContext(name = "WORLD_PU")
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
    public DbVersion getWorldDBVersion() {
        logger.debug("getWorldDBVersion() entry.");

        DbVersion version = (DbVersion) emWorld.createNamedQuery("DbVersion.findAll").getSingleResult();

        logger.debug("getWorldDBVersion() exit.");
        return version;
    }
}