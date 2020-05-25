package org.vast.ows.wmts;

import org.vast.ows.AbstractRequestWriter;
import org.vast.ows.OWSException;
import org.vast.xml.DOMHelper;
import org.w3c.dom.Element;

public class GetTileWriterV10 extends AbstractRequestWriter<GetTileRequest> {

    public GetTileWriterV10() {
    }


    @Override
    public String buildURLQuery(GetTileRequest request) throws OWSException {
        StringBuilder urlBuff = new StringBuilder(request.getGetServer());

        urlBuff.append("wmtver=" + request.getVersion());
        urlBuff.append("&request=tile");

        urlBuff.append("&layer=" + request.getLayer());

        urlBuff.append("&style=" + request.getStyle());

        urlBuff.append("&format=" + request.getFormat());

        urlBuff.append("&TileMatrixSet=" + request.getTileMatrixSet());

        urlBuff.append("&TileMatrix=" + request.getTileMatrix());

        urlBuff.append("&TileCol=" + request.getTileCol());

        urlBuff.append("&TileRow=" + request.getTileCol());

        String dimension = createDimensions(request);
        if(!dimension.isEmpty()) {
            urlBuff.append("&");
            urlBuff.append(dimension);
        }

        String url = urlBuff.toString();
        url.replaceAll(" ", "%20");
        return url;
    }


    @Override
    public Element buildXMLQuery(DOMHelper dom, GetTileRequest request) throws OWSException {
        throw new WMTSException(noXML + "WMS 1.0");
    }


    /**
     * Create comma separated layer list for GET request
     *
     * @param request
     * @return
     */
    protected String createDimensions(GetTileRequest request) {
        StringBuffer buff = new StringBuffer();

        int dimensionCount = request.getDimensions().size();
        int i=0;
        for (String key : request.getDimensions().keySet()) {
            buff.append(request.getDimensions().get(key));
            buff.append("=");
            buff.append(request.getDimensions().get(key));

            if (++i != dimensionCount - 1)
                buff.append('&');
        }

        return buff.toString();
    }
}
