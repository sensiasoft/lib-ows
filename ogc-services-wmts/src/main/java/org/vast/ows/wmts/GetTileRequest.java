package org.vast.ows.wmts;

import org.vast.ows.OWSRequest;

import java.util.HashMap;
import java.util.Map;

public class GetTileRequest extends OWSRequest {

    protected String layer;
    protected String style;
    protected Map<String, Object> dimensions;
    protected String format;
    protected String tileMatrixSet;
    protected String tileMatrix;
    protected String tileRow;
    protected String tileCol;

    public GetTileRequest() {
        service = "WMTS";
        operation = "GetTile";
        dimensions = new HashMap<>(1);
    }


    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Map<String, Object> getDimensions() {
        return dimensions;
    }

    public void setDimensions(Map<String, Object> dimensions) {
        this.dimensions = dimensions;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTileMatrixSet() {
        return tileMatrixSet;
    }

    public void setTileMatrixSet(String tileMatrixSet) {
        this.tileMatrixSet = tileMatrixSet;
    }

    public String getTileMatrix() {
        return tileMatrix;
    }

    public void setTileMatrix(String tileMatrix) {
        this.tileMatrix = tileMatrix;
    }

    public String getTileRow() {
        return tileRow;
    }

    public void setTileRow(String tileRow) {
        this.tileRow = tileRow;
    }

    public String getTileCol() {
        return tileCol;
    }

    public void setTileCol(String tileCol) {
        this.tileCol = tileCol;
    }
}
