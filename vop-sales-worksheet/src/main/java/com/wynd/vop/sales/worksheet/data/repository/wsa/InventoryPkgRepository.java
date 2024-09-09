package com.wynd.vop.sales.worksheet.data.repository.wsa;

import com.wynd.vop.sales.worksheet.data.entity.SalesPkgInventory;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link SalesPkgInventory} entity.
 * <p>
 * This interface extends {@link JpaRepository} to provide CRUD (Create, Read, Update, Delete) operations
 * for {@link SalesPkgInventory} entities. By extending {@link JpaRepository}, it inherits a set of standard
 * methods for interacting with the database, such as saving, finding, and deleting entities.
 * </p>
 * <p>
 * The {@code @Repository} annotation indicates that this interface is a Spring Data repository, and the
 * {@code @Lazy} annotation ensures that the repository bean is created lazily, only when it is first needed.
 * </p>
 *
 * @see SalesPkgInventory
 * @see JpaRepository
 */
@Lazy
@Repository
public interface InventoryPkgRepository extends JpaRepository<SalesPkgInventory, String> {

}
