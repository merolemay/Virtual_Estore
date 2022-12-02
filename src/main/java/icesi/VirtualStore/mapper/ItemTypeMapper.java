package icesi.VirtualStore.mapper;

import icesi.VirtualStore.dto.ItemTypeDTO;
import icesi.VirtualStore.model.ItemType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemTypeMapper {
    ItemTypeDTO fromItem(ItemType itemType);
    ItemType fromDTO(ItemTypeDTO itemTypeDTO);
}
