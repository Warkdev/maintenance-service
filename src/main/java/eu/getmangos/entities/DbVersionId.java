package eu.getmangos.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

/**
* Composite Primary Key for DbVersion
*/
@Embeddable
@Data
public class DbVersionId implements Serializable {
    private static final long serialVersionUID = 1L;

    private int version;
    private int structure;
    private int content;
}
