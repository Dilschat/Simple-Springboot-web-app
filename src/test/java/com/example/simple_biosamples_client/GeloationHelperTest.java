package com.example.simple_biosamples_client;

import com.example.simple_biosamples_client.services.utils.GeoLocationDataHelper;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class GeloationHelperTest {

    @Test
    public void type_determination_test() {
        String val1 = "geographic location";
        String val2 = "latitude";
        String val3 = "longitude";
        String val4 = "altitude";
        String val5 = "precision";
        GeoLocationDataHelper helper = new GeoLocationDataHelper();
        assertTrue(helper.isGeoLocationData(val1));
        assertTrue(helper.isGeoLocationData(val2));
        assertTrue(helper.isGeoLocationData(val3));
        assertTrue(helper.isGeoLocationData(val4));
        assertTrue(helper.isGeoLocationData(val5));
    }

    @Test
    public void convertation_to_decimal_test() {


    }
}
