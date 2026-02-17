package org.nooshet.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.nooshet.user.entity.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "user_profiles")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile extends BaseEntity {

    @Column(name = "account_id", unique = true, nullable = false)
    private Long accountId;

    private String name;

    @Column(name = "avatar_url")
    private String avatarUrl;

    private String language;

    @Column(name = "setup_required", nullable = false)
    private boolean setupRequired = true;

}
