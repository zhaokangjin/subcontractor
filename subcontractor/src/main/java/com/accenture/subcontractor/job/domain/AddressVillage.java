package com.accenture.subcontractor.job.domain;

public class AddressVillage {
    //  >>>表字段 : id
    private Integer id;

    // 镇id >>>表字段 : town_id
    private Long townId;

    // 村id--唯一 >>>表字段 : village_id
    private Long villageId;

    //  >>>表字段 : village_name
    private String villageName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public Long getVillageId() {
        return villageId;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }
}