package com.darren.factories;

import com.darren.domain.Region;

public class RegionFactory {

    public static Region buildRegion(String regionId, String regionName, String regionLocation)
    {
        Region region = new Region.Builder()
                .regionId(regionId)
                .regionName(regionName)
                .regionLocation(regionLocation)
                .build();
        return region;
    }
}