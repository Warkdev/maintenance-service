package eu.getmangos.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import eu.getmangos.dto.DbVersionDTO;
import eu.getmangos.entities.DbVersion;

@Mapper(componentModel = "cdi")
public interface VersionMapper {

    @Mapping(source = "version.id.version", target = "version")
    @Mapping(source = "version.id.structure", target = "structure")
    @Mapping(source = "version.id.content", target = "content")
    DbVersionDTO versionToDTO(DbVersion version);

    @InheritInverseConfiguration
    DbVersion dtoToEntity(DbVersionDTO version);

}
