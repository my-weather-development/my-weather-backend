package com.github.evgolya.autocomplete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityAutocompleteRepository extends JpaRepository<Settlement, Long> {
}
