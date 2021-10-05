package com.github.evgolya.autocomplete;

import java.util.List;

public class LocalityAutocompleteDto {

    private final List<LocalityAutocomplete> localities;

    public List<LocalityAutocomplete> getLocalities() {
        return localities;
    }

    public LocalityAutocompleteDto(List<LocalityAutocomplete> localities) {
        this.localities = localities;
    }
}
