/***************************** BEGIN LICENSE BLOCK ***************************

 The contents of this file are subject to the Mozilla Public License Version
 1.1 (the "License"); you may not use this file except in compliance with
 the License. You may obtain a copy of the License at
 http://www.mozilla.org/MPL/MPL-1.1.html
 
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 for the specific language governing rights and limitations under the License.
 
 The Original Code is the "SensorML DataProcessing Engine".
 
 The Initial Developer of the Original Code is the
 University of Alabama in Huntsville (UAH).
 Portions created by the Initial Developer are Copyright (C) 2006
 the Initial Developer. All Rights Reserved.
 
 Contributor(s): 
    Alexandre Robin <robin@nsstc.uah.edu>
    Tony Cook <tcook@nsstc.uah.edu>
 
******************************* END LICENSE BLOCK ***************************/

package org.vast.ows;

import org.w3c.dom.*;
import org.vast.xml.DOMHelper;


/**
 * <p><b>Title:</b><br/>
 * GetCapabilities Request Builder v1.0
 * </p>
 *
 * <p><b>Description:</b><br/>
 * Provides methods to generate a KVP or XML GetCapabilities request based
 * on values contained in a GetCapabilities object for version 1.0
 * </p>
 *
 * <p>Copyright (c) 2007</p>
 * @author Alexandre Robin
 * @date Sep 21, 2007
 * @version 1.0
 */
public class GetCapabilitiesWriter extends AbstractRequestWriter<GetCapabilitiesRequest>
{
	
	@Override
	public String buildURLQuery(GetCapabilitiesRequest query) throws OWSException
	{
		StringBuffer urlBuff = new StringBuffer(query.getGetServer());
		
        urlBuff.append("SERVICE=" + query.getService());
        urlBuff.append("&VERSION=" + query.getVersion());
        urlBuff.append("&REQUEST=" + query.getOperation());
		
        if (query.getSection() != null)
        	urlBuff.append("&SECTION=" + query.getSection());
        
        return urlBuff.toString();
	}
	
	
	@Override
	public Element buildXMLQuery(DOMHelper dom, GetCapabilitiesRequest request) throws OWSException
	{
		Element rootElt = dom.createElement(request.getOperation());
		dom.setAttributeValue(rootElt, "version", request.getVersion());
		dom.setAttributeValue(rootElt, "service", request.getService());
		
		if (request.getSection() != null)
			dom.setElementValue(rootElt, "section", request.getSection());
		
		return rootElt;
	}
}