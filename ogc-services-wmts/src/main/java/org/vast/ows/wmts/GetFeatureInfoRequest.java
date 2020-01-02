/***************************** BEGIN LICENSE BLOCK ***************************

 The contents of this file are subject to the Mozilla Public License Version
 1.1 (the "License"); you may not use this file except in compliance with
 the License. You may obtain a copy of the License at
 http://www.mozilla.org/MPL/MPL-1.1.html

 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 for the specific language governing rights and limitations under the License.

 The Original Code is the "OGC Service Framework".

 The Initial Developer of the Original Code is the VAST team at the
 University of Alabama in Huntsville (UAH). <http://vast.uah.edu>
 Portions created by the Initial Developer are Copyright (C) 2007
 the Initial Developer. All Rights Reserved.

 Please Contact Mike Botts <mike.botts@uah.edu> for more information.

 Contributor(s): 
 Alexandre Robin <robin@nsstc.uah.edu>

 ******************************* END LICENSE BLOCK ***************************/

package org.vast.ows.wmts;

import org.vast.ows.OWSRequest;

import java.util.HashMap;
import java.util.Map;

public class GetFeatureInfoRequest extends OWSRequest {

    private String I;
    private String J;
    private String infoFormat;
    protected String layer;
    protected String style;
    protected Map<String, Object> dimensions;
    protected String format;
    protected String tileMatrixSet;
    protected String tileMatrix;
    protected String tileRow;
    protected String tileCol;

    public GetFeatureInfoRequest() {
        service = "WMTS";
        operation = "GetFeatureInfo";
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

    public String getI() {
        return I;
    }

    public void setI(String i) {
        I = i;
    }

    public String getJ() {
        return J;
    }

    public void setJ(String j) {
        J = j;
    }

    public String getInfoFormat() {
        return infoFormat;
    }

    public void setInfoFormat(String infoFormat) {
        this.infoFormat = infoFormat;
    }
}
