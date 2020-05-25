package org.vast.ows.wms;


import java.util.ArrayList;
import java.util.List;

public class GetFeatureInfoRequest extends GetMapRequest {
    protected String infoFormat;
    protected int x;
    protected int y;
    protected List<String> queryLayers;
    protected int featureCount;

    public GetFeatureInfoRequest() {
        service = "WMS";
        operation = "GetFeatureInfo";
        layers = new ArrayList<>(1);
        queryLayers = new ArrayList<>(1);
        x = -1;
        y = -1;
        featureCount = 0;
    }

    public String getInfoFormat() {
        return infoFormat;
    }

    public void setInfoFormat(String infoFormat) {
        this.infoFormat = infoFormat;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<String> getQueryLayers() {
        return queryLayers;
    }

    public void setQueryLayers(List<String> queryLayers) {
        this.queryLayers = queryLayers;
    }

    public int getFeatureCount() {
        return featureCount;
    }

    public void setFeatureCount(int featureCount) {
        this.featureCount = featureCount;
    }
}
