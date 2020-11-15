package eu.getmangos.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(
    name="db_version"
)
@NamedQueries({
    @NamedQuery(name = "DbVersion.findAll", query="SELECT d from DbVersion d")
})
@Data
public class DbVersion implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private DbVersionId id;

    @NotNull
    @Column(name="description", length = 30)
    private String description;

    @Column(name="comment", length = 150)
    private String comment;
}
