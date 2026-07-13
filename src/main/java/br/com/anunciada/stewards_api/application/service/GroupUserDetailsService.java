package br.com.anunciada.stewards_api.application.service;

import br.com.anunciada.stewards_api.infra.persistence.repository.GroupRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GroupUserDetailsService implements UserDetailsService {

    private final GroupRepository repository;

    public GroupUserDetailsService(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
            return repository
                .findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                "Grupo não encontrado"
                        )
                );
    }
}