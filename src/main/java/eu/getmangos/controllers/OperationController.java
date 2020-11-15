package eu.getmangos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;

import eu.getmangos.dto.CleanupPreviewDTO;
import eu.getmangos.dto.CleanupSummaryDTO;

@RequestScoped
public class OperationController {
    @Inject private Logger logger;

    /**
     * Clean-up all dead links from the database.
     * @return An Map containing a list of items and the amount of deleted records.
     */
    @Transactional
    public CleanupSummaryDTO cleanup() throws DAOException {
        logger.debug("cleanup() entry.");

        CleanupSummaryDTO summary = new CleanupSummaryDTO();

        // Clean-up bans
        //deletedItems.put("bans", accountBannedController.cleanupDeadLinks());

        // Clean-up links
        ///deletedItems.put("links", realmCharactersController.cleanupDeadLinks());

        // Clean-up Uptimes
        //deletedItems.put("uptime", uptimeController.cleanupDeadLinks());

        // Clean-up Warden Logs
        //deletedItems.put("warden_logs", wardenController.cleanupDeadLinks());

        logger.debug("cleanup() exit.");
        return summary;
    }

    /**
     * Retrieves the list of all items which will be deleted by the clean-up operation.
     * @return An Map containing a list of items which will be deleted.
     */
    @Transactional
    public CleanupPreviewDTO getCleanup() throws DAOException {
        logger.debug("getCleanup() entry.");

        CleanupPreviewDTO preview = new CleanupPreviewDTO();

        //deletedItems.put("bans", accountBannedController.findDeadLinks());
        //deletedItems.put("links", realmCharactersController.findDeadLinks());
        //deletedItems.put("uptime", uptimeController.findDeadLinks());
        //deletedItems.put("warden_logs", wardenController.findDeadLinks());

        logger.debug("getCleanup() exit.");
        return preview;
    }
}
