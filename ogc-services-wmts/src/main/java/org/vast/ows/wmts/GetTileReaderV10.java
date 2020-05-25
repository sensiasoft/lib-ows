package org.vast.ows.wmts;

import org.vast.ows.AbstractRequestReader;
import org.vast.ows.OWSException;
import org.vast.ows.OWSExceptionReport;
import org.vast.ows.OWSUtils;
import org.vast.xml.DOMHelper;
import org.w3c.dom.Element;

import java.util.Iterator;
import java.util.Map;

public class GetTileReaderV10 extends AbstractRequestReader<GetTileRequest> {

    public GetTileReaderV10() {
        this.owsVersion = OWSException.VERSION_10;
    }

    @Override
    public GetTileRequest readURLParameters(Map<String, String> queryParameters) throws OWSException {
        GetTileRequest request = new GetTileRequest();
        OWSExceptionReport report = new OWSExceptionReport(owsVersion);
        Iterator<Map.Entry<String, String>> it = queryParameters.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, String> item = it.next();
            String argName = item.getKey();
            String argValue = item.getValue();

            try {
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

                // layer argument
                else if (argName.equalsIgnoreCase("layer")) {
                    request.setLayer(argValue);
                }

                // styles argument
                else if (argName.equalsIgnoreCase("style")) {
                    request.setStyle(argValue);
                }

                // format argument
                else if (argName.equalsIgnoreCase("format")) {
                    request.setFormat(argValue);
                }

                // tileMatrixSet argument
                else if (argName.equalsIgnoreCase("tileMatrixSet")) {
                    request.setTileMatrixSet(argValue);
                }

                // tileMatrix argument
                else if (argName.equalsIgnoreCase("tileMatrix")) {
                    request.setTileMatrix(argValue);
                }

                // tileRow argument
                else if (argName.equalsIgnoreCase("tileRow")) {
                    request.setTileRow(argValue);
                }

                // tileCol argument
                else if (argName.equalsIgnoreCase("tileCol")) {
                    request.setTileCol(argValue);
                }

                // dimensions parameters
                else {
                    request.getDimensions().put(argName, argValue);
                }
            } catch (Exception e) {
                report.add(new WMTSException(OWSException.invalid_param_code, argName.toUpperCase(), argValue, null));
            }
        }

        report.process();
        this.checkParameters(request, report);
        return request;
    }


    @Override
    public GetTileRequest readXMLQuery(DOMHelper dom, Element requestElt) throws OWSException {
        throw new WMTSException(noXML + "WMTS 1.0 GetTile");
    }


    /**
     * Checks that GetMap mandatory parameters are present
     *
     * @param request
     * @throws OWSException
     */
    protected void checkParameters(GetTileRequest request, OWSExceptionReport report) throws OWSException {
        // check common params
        super.checkParameters(request, report, OWSUtils.WMS);

        // need layer
        if (request.getLayer() == null || request.getLayer().isEmpty())
            report.add(new WMTSException(OWSException.missing_param_code, "LAYER"));

        // need style
        if (request.getStyle() == null || request.getStyle().isEmpty())
            report.add(new WMTSException(OWSException.missing_param_code, "STYLE"));

        // need format
        if (request.getFormat() == null || request.getFormat().isEmpty())
            report.add(new WMTSException(OWSException.missing_param_code, "FORMAT"));

        // need tileMatrixSet
        if (request.getTileMatrixSet() == null || request.getTileMatrixSet().isEmpty())
            report.add(new WMTSException(OWSException.missing_param_code, "TILE_MATRIX_SET"));

        // need tileMatrix
        if (request.getTileMatrix() == null || request.getTileMatrix().isEmpty())
            report.add(new WMTSException(OWSException.missing_param_code, "TILE_MATRIX"));

        // need tileRow
        if (request.getTileRow() == null || request.getTileRow().isEmpty())
            report.add(new WMTSException(OWSException.missing_param_code, "TILE_ROW"));

        // need tileCol
        if (request.getTileCol() == null || request.getTileCol().isEmpty())
            report.add(new WMTSException(OWSException.missing_param_code, "TILE_COL"));


        report.process();
    }
}
