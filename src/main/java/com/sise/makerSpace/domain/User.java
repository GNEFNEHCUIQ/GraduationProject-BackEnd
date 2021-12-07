package com.sise.makerSpace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Repository
public class User implements /*Serializable,*/ UserDetails {
        private int user_id;
        private String password;
        private String user_name;
        private List<Role> roles;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> authorities=roles
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getRole_name()))
                        .collect(Collectors.toList());
                return authorities;
        }

        @Override
        public String getUsername() {
                return this.user_name;
        }


        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return true;
        }

}
