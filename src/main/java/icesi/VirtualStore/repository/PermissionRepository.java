package icesi.VirtualStore.repository;

import icesi.VirtualStore.model.Permission;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PermissionRepository extends CrudRepository<Permission, UUID> {
}
