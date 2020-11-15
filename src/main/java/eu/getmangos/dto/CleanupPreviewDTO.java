package eu.getmangos.dto;

import java.io.Serializable;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString @EqualsAndHashCode
public class CleanupPreviewDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Schema(description = "Amount of ban records which are orphan")
    private List<BansDTO> bans;

    @Schema(description = "Amount of account-realm links which are orphan")
    private List<LinksDTO> links;

    @Schema(description = "Amount of uptime statistics which are orphan")
    private List<UptimeDTO> uptime;

    @Schema(description = "Amount of warden logs which are orphan")
    private List<WardenLogDTO> wardenLogs;
}
