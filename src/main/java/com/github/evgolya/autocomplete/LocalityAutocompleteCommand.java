package com.github.evgolya.autocomplete;

import java.util.Objects;

public class LocalityAutocompleteCommand {

    // TODO: get country from cache

    private String locality;

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalityAutocompleteCommand that = (LocalityAutocompleteCommand) o;
        return Objects.equals(locality, that.locality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locality);
    }
}
