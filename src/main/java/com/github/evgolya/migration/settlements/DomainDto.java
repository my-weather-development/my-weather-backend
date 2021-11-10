package com.github.evgolya.migration.settlements;

import java.util.Objects;

public class DomainDto {

    private String title;

    private Boolean isState;

    public String getTitle() {
        return title;
    }

    public DomainDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public Boolean isState() {
        return isState;
    }

    public DomainDto setIsState(Boolean state) {
        isState = state;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainDto domainDto = (DomainDto) o;
        return Objects.equals(title, domainDto.title) &&
            Objects.equals(isState, domainDto.isState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, isState);
    }
}
