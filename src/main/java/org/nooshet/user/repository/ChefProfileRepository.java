package org.nooshet.user.repository;

import org.nooshet.user.entity.ChefProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: nijataghayev
 */

@Repository
public interface ChefProfileRepository extends JpaRepository<ChefProfile, Long> {

    boolean existsByEmail(String email);
}
