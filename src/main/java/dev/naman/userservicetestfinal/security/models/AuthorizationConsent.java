package dev.naman.userservicetestfinal.security.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "`authorizationConsent`")
@IdClass(AuthorizationConsent.AuthorizationConsentId.class)
@Getter
@Setter
public class AuthorizationConsent {
    @Id
    private String registeredClientId;
    @Id
    private String principalName;
    @Column(length = 1000)
    private String authorities;

    public static class AuthorizationConsentId implements Serializable {
        private String registeredClientId;
        private String principalName;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AuthorizationConsentId that = (AuthorizationConsentId) o;
            return registeredClientId.equals(that.registeredClientId) && principalName.equals(that.principalName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(registeredClientId, principalName);
        }
    }
}