package com.codegym.model.dto;

import com.codegym.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LocationDTO {
    private Long id;

    @NotEmpty(message = "Province Id cannot be empty")
    private String provinceId;

    @NotEmpty(message = "Province name cannot be empty")
    private String provinceName;

    @NotEmpty(message = "District Id cannot be empty")
    private String districtId;

    @NotEmpty(message = "District name cannot be empty")
    private String districtName;

    @NotEmpty(message = "Ward Id cannot be empty")
    private String wardId;

    @NotEmpty(message = "Ward name cannot be empty")
    private String wardName;

    private String address;

    public Location toLocation() {
        Location location = new Location();

        location.setId(this.id);
        location.setProvinceId(this.provinceId);
        location.setProvinceName(this.provinceName);
        location.setDistrictId(this.districtId);
        location.setDistrictName(this.districtName);
        location.setWardId(this.wardId);
        location.setWardName(this.wardName);
        location.setAddress(this.address);

        return location;
    }
}
