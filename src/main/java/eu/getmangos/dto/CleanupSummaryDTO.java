package eu.getmangos.dto;

import java.io.Serializable;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
public class CleanupSummaryDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Schema(description = "Amount of bans records which have been deleted")
    private Integer bans;

    @Schema(description = "Amount of account-realms links which have been deleted")
    private Integer links;

    @Schema(description = "Amount of realm uptime statistics which have been deleted")
    private Integer uptime;

    @Schema(description = "Amount of warden logs which have been deleted")
    private Integer wardenLogs;
}
