package org.vast.ows.wmts;

import org.vast.ows.GetCapabilitiesRequest;
import org.vast.ows.OWSException;
import org.vast.ows.OWSRequest;
import org.vast.ows.server.OWSServlet;

public abstract class WMTSServlet extends OWSServlet {

    @Override
    public void handleRequest(OWSRequest request) throws OWSException {
        if (request instanceof GetTileRequest) {
            processQuery((GetTileRequest) request);
        } else if (request instanceof GetCapabilitiesRequest) {
            processQuery((GetCapabilitiesRequest) request);
        } else if (request instanceof GetFeatureInfoRequest) {
            processQuery((GetFeatureInfoRequest) request);
        } else
            throw new OWSException("Unsupported operation " + request.getOperation());
    }


    public abstract void processQuery(GetTileRequest request) throws OWSException;

    public abstract void processQuery(GetCapabilitiesRequest request) throws OWSException;

    public abstract void processQuery(GetFeatureInfoRequest request) throws OWSException;


}
