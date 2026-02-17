package org.nooshet.user.entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_modes")
public class UserMode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String modeName;

    public UserMode() {
    }

    public UserMode(String modeName) {
        this.modeName = modeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMode userMode = (UserMode) o;
        return Objects.equals(id, userMode.id) && Objects.equals(modeName, userMode.modeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modeName);
    }

    @Override
    public String toString() {
        return "UserMode{" +
                "id=" + id +
                ", modeName='" + modeName + '\'' +
                '}';
    }
}
