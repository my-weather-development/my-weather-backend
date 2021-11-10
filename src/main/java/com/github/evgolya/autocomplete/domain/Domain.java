package com.github.evgolya.autocomplete.domain;

import com.github.evgolya.autocomplete.country.Country;
import com.github.evgolya.autocomplete.settlement.Settlement;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// AdministrativeTerritorialUnit as alias
@Entity
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Boolean isState;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Country country;

    @OneToMany(mappedBy = "domain")
    private List<Settlement> settlements = new ArrayList<>();

    public Domain() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getState() {
        return isState;
    }

    public void setState(Boolean state) {
        isState = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Settlement> getSettlements() {
        return settlements;
    }

    public void setSettlements(List<Settlement> settlements) {
        this.settlements = settlements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domain domain = (Domain) o;
        return Objects.equals(id, domain.id) &&
            Objects.equals(title, domain.title) &&
            Objects.equals(isState, domain.isState) &&
            Objects.equals(country, domain.country) &&
            Objects.equals(settlements, domain.settlements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isState, country, settlements);
    }
}
