package dev.naman.userservicetestfinal.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.naman.userservicetestfinal.models.Role;
import dev.naman.userservicetestfinal.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@JsonDeserialize(as = CustomSpringUserDetails.class)
public class CustomSpringUserDetails implements UserDetails, Serializable {
    private User user;

    public CustomSpringUserDetails() {}

    public CustomSpringUserDetails(User user) {
        this.user = user;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<CustomSpringGrantedAuthority> customSpringGrantedAuthorities = new ArrayList<>();

        for (Role role: user.getRoles()) {
            customSpringGrantedAuthorities.add(
                    new CustomSpringGrantedAuthority(role)
            );
        }

        return customSpringGrantedAuthorities;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }
}
