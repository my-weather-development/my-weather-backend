package com.github.evgolya.autocomplete.settlement;

import com.github.evgolya.autocomplete.domain.Domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Domain domain;

    private String locality;

    private String ascii;

    private Double latitude;

    private Double longitude;

    public Settlement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAscii() {
        return ascii;
    }

    public void setAscii(String ascii) {
        this.ascii = ascii;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public static SettlementBuilder builder() {
        return new SettlementBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Settlement that = (Settlement) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(domain, that.domain) &&
            Objects.equals(locality, that.locality) &&
            Objects.equals(ascii, that.ascii) &&
            Objects.equals(latitude, that.latitude) &&
            Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, domain, locality, ascii, latitude, longitude);
    }

    public static final class SettlementBuilder {

        private Domain domain;
        private String locality;
        private String ascii;
        private Double latitude;
        private Double longitude;

        public SettlementBuilder setDomain(Domain domain) {
            this.domain = domain;
            return this;
        }

        public SettlementBuilder setLocality(String locality) {
            this.locality = locality;
            return this;
        }

        public SettlementBuilder setAscii(String ascii) {
            this.ascii = ascii;
            return this;
        }

        public SettlementBuilder setLatitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public SettlementBuilder setLongitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public Settlement build() {
            final Settlement settlement = new Settlement();
            settlement.setDomain(this.domain);
            settlement.setLocality(this.locality);
            settlement.setAscii(this.ascii);
            settlement.setLatitude(this.latitude);
            settlement.setLongitude(this.longitude);
            return settlement;
        }
    }
}
