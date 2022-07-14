package com.codegym.model;

import com.codegym.model.dto.LocationDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String provinceId;

    @Column(nullable = false)
    private String provinceName;

    @Column(nullable = false)
    private String districtId;

    @Column(nullable = false)
    private String districtName;

    @Column(nullable = false)
    private String wardId;

    @Column(nullable = false)
    private String wardName;

    @Column
    private String address;

    public LocationDTO toLocationDTO() {
        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setId(this.id);
        locationDTO.setProvinceId(this.provinceId);
        locationDTO.setProvinceName(this.provinceName);
        locationDTO.setDistrictId(this.districtId);
        locationDTO.setDistrictName(this.districtName);
        locationDTO.setWardId(this.wardId);
        locationDTO.setWardName(this.wardName);
        locationDTO.setAddress(this.address);

        return locationDTO;
    }
}
