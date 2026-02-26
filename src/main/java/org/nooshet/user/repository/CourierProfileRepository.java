package org.nooshet.user.repository;

import org.nooshet.user.entity.CourierProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: nijataghayev
 */

@Repository
public interface CourierProfileRepository extends JpaRepository<CourierProfile, Long> {

    boolean existsByPhoneNumber(String phoneNumber);
    void deleteByAccountId(Long accountId);
}
