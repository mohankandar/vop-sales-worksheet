package com.wynd.vop.sales.worksheet.data.repository.wsa;

import com.wynd.vop.sales.worksheet.data.entity.SalesPresetPkgInventory;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository interface for {@link SalesPresetPkgInventory} entity.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD (Create, Read, Update, Delete) operations
 * for {@link SalesPresetPkgInventory} entities. It facilitates the management and retrieval of {@link SalesPresetPkgInventory}
 * data from the database using methods provided by {@link JpaRepository}.
 * </p>
 * <p>
 * By extending {@link JpaRepository}, this repository inherits methods for common data access operations, such as saving,
 * finding, and deleting entities. The {@link Repository} annotation indicates that this interface is a Spring Data JPA
 * repository, while the {@link Lazy} annotation ensures that the repository bean is created lazily, only when needed.
 * </p>
 *
 * @see SalesPresetPkgInventory
 * @see JpaRepository
 */
@Lazy
@Repository
public interface InventoryPresetPkgRepository extends JpaRepository<SalesPresetPkgInventory, Long> {

  /**
   * Finds a {@link SalesPresetPkgInventory} entity by site ID and service entity.
   * @return a {@link SalesPresetPkgInventory} entity
   */
  List<SalesPresetPkgInventory> findBySiteIdAndServiceEntity(BigDecimal siteId, String entityId);

}
