package kitchenpos.menugroup.domain.repository;

import kitchenpos.menugroup.domain.entity.MenuGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuGroupRepository extends JpaRepository<MenuGroup, Long> {

}
