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
 Alexandre Robin <alexandre.robin@spotimage.fr>

 ******************************* END LICENSE BLOCK ***************************/

package org.vast.ows.wms;

import org.vast.ows.AbstractRequestReader;
import org.vast.ows.OWSException;
import org.vast.ows.OWSExceptionReport;
import org.vast.ows.OWSUtils;
import org.vast.util.Bbox;
import org.vast.util.TimeExtent;
import org.vast.xml.DOMHelper;
import org.w3c.dom.Element;

import java.awt.*;
import java.util.Iterator;
import java.util.Map;


/**
 * <p>
 * Provides methods to parse a KVP or XML GetMap request and
 * create a GetMapRequest object for version 1.1
 * </p>
 */
public class GetFeatureInfoReaderV13 extends AbstractRequestReader<GetFeatureInfoRequest> {


    public GetFeatureInfoReaderV13() {
        this.owsVersion = OWSException.VERSION_11;
    }


    @Override
    public GetFeatureInfoRequest readURLParameters(Map<String, String> queryParameters) throws OWSException {
        GetFeatureInfoRequest request = new GetFeatureInfoRequest();
        OWSExceptionReport report = new OWSExceptionReport(owsVersion);
        Iterator<Map.Entry<String, String>> it = queryParameters.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, String> item = it.next();
            String argName = item.getKey();
            String argValue = item.getValue();

            try {
                // GetMap parameters
                // service ID
                if (argName.equalsIgnoreCase("service")) {
                    request.setService(argValue);
                }

                // service version
                else if (argName.equalsIgnoreCase("version")) {
                    request.setVersion(argValue);
                }

                // request argument
                else if (argName.equalsIgnoreCase("request")) {
                    request.setOperation(argValue);
                }

                // layers argument
                else if (argName.equalsIgnoreCase("layers")) {
                    String[] layerList = argValue.split(",");
                    request.getLayers().clear();
                    for (int i = 0; i < layerList.length; i++)
                        request.getLayers().add(layerList[i]);
                }

                // styles argument
                else if (argName.equalsIgnoreCase("styles")) {
                    String[] styleList = argValue.split(",");
                    request.getStyles().clear();
                    for (int i = 0; i < styleList.length; i++)
                        request.getStyles().add(styleList[i]);
                }

                // srs
                else if (argName.equalsIgnoreCase("crs")) {
                    request.setSrs(argValue);
                }

                // bbox
                else if (argName.equalsIgnoreCase("bbox")) {
                    Bbox bbox = parseBboxArg(argValue);
                    request.setBbox(bbox);
                }

                // width
                else if (argName.equalsIgnoreCase("width")) {
                    request.setWidth(Integer.parseInt(argValue));
                    if (request.getWidth() <= 0)
                        throw new IllegalArgumentException();
                }

                // height
                else if (argName.equalsIgnoreCase("height")) {
                    request.setHeight(Integer.parseInt(argValue));
                    if (request.getHeight() <= 0)
                        throw new IllegalArgumentException();
                }

                // format
                else if (argName.equalsIgnoreCase("format")) {
                    request.setFormat(argValue);
                }

                // transparency
                else if (argName.equalsIgnoreCase("transparent")) {
                    request.setTransparent(Boolean.parseBoolean(argValue));
                }

                // bgcolor
                else if (argName.equalsIgnoreCase("bgcolor")) {
                    request.setBackgroundColor(parseBgColor(argValue));
                }

                // time
                else if (argName.equalsIgnoreCase("time")) {
                    TimeExtent time = parseTimeArg(argValue);
                    request.setTime(time);
                }

                //-- GetFeatureInfo parameters

                // QUERY_LAYERS argument
                else if (argName.equalsIgnoreCase("QUERY_LAYERS")) {
                    String[] layerList = argValue.split(",");
                    request.getQueryLayers().clear();
                    for (int i = 0; i < layerList.length; i++)
                        request.getQueryLayers().add(layerList[i]);
                }

                // INFO_FORMAT
                else if (argName.equalsIgnoreCase("INFO_FORMAT")) {
                    request.setInfoFormat(argValue);
                }

                // FEATURE_COUNT
                else if (argName.equalsIgnoreCase("FEATURE_COUNT")) {
                    request.setFeatureCount(Integer.parseInt(argValue));
                }

                // x
                else if (argName.equalsIgnoreCase("I")) {
                    request.setX(Integer.parseInt(argValue));
                }

                // y
                else if (argName.equalsIgnoreCase("J")) {
                    request.setY(Integer.parseInt(argValue));
                }

                // vendor parameters
                else {
                    if (argValue == null)
                        argValue = "";
                    addKVPExtension(argName, argValue, request);
                }
            } catch (Exception e) {
                report.add(new WMSException(OWSException.invalid_param_code, argName.toUpperCase(), argValue, null));
            }
        }

        report.process();
        this.checkParameters(request, report);
        return request;
    }


    /**
     * Parses background color from RGB hexadecimal string (e.g. 0xA51CFF)
     *
     * @param argValue
     * @return
     */
    protected Color parseBgColor(String argValue) {
        if (argValue == null || !argValue.matches("0(x|X)[0-9a-fA-F]{6}"))
            throw new IllegalArgumentException();

        argValue.replaceFirst("0x|0X", "");
        return Color.decode(argValue);
    }

    @Override
    public GetFeatureInfoRequest readXMLQuery(DOMHelper dom, Element requestElt) throws OWSException {
        throw new WMSException(noXML + "WMS 1.3.0 GetFeatureInfo");
    }


    /**
     * Checks that GetFeatureInfo mandatory parameters are present
     *
     * @param request
     * @throws OWSException
     */
    protected void checkParameters(GetFeatureInfoRequest request, OWSExceptionReport report) throws OWSException {
        // check common params
        super.checkParameters(request, report, OWSUtils.WMS);

        // need layer
        if (request.getLayers() == null || request.getLayers().isEmpty())
            report.add(new WMSException(OWSException.missing_param_code, "LAYERS"));

        // need at least BBOX
        if (request.getBbox() == null || request.getBbox().isNull())
            report.add(new WMSException(OWSException.missing_param_code, "BBOX"));

        // need format
        if (request.getFormat() == null || request.getFormat().length() == 0)
            report.add(new WMSException(OWSException.missing_param_code, "FORMAT"));

        // need SRS
        if (request.getSrs() == null || request.getSrs().length() == 0)
            report.add(new WMSException(OWSException.missing_param_code, "SRS"));

        // need style
        if (request.getStyles() == null)
            report.add(new WMSException(OWSException.missing_param_code, "STYLES"));

        // width is positive
        if (request.getWidth() <= 0)
            report.add(new WMSException(OWSException.missing_param_code, "WIDTH"));

        // height is positive
        if (request.getHeight() <= 0)
            report.add(new WMSException(OWSException.missing_param_code, "HEIGHT"));

        // need QUERY_LAYERS
        if (request.getQueryLayers() == null || request.getQueryLayers().isEmpty())
            report.add(new WMSException(OWSException.missing_param_code, "QUERY_LAYERS"));

        // need X
        if (request.getBbox() == null && request.getX() == -1)
            report.add(new WMSException(OWSException.missing_param_code, "I"));

        // need Y
        if (request.getBbox() == null && request.getY() == -1)
            report.add(new WMSException(OWSException.missing_param_code, "J"));

        report.process();
    }
}