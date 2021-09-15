package com.github.evgolya.geolocationapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeLocationItemDto {

    private String title;

    private String id;

    private String resultType;

    private String localityType;

    @JsonProperty("address")
    private Locality locality;

    @JsonProperty("position")
    private Coordinates coordinates;

    private MapView mapView;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getLocalityType() {
        return localityType;
    }

    public void setLocalityType(String localityType) {
        this.localityType = localityType;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public MapView getMapView() {
        return mapView;
    }

    public void setMapView(MapView mapView) {
        this.mapView = mapView;
    }

    @Override
    public String toString() {
        return "GeocodeLocationItemDto{" +
            "title='" + title + '\'' +
            ", id='" + id + '\'' +
            ", resultType='" + resultType + '\'' +
            ", localityType='" + localityType + '\'' +
            ", locality=" + locality +
            ", coordinates=" + coordinates +
            ", mapView=" + mapView +
            '}';
    }
}
