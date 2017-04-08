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
 
 Contributor(s): 
    Alexandre Robin <alexandre.robin@spotimage.fr>
 
******************************* END LICENSE BLOCK ***************************/

package org.vast.ows.sps;

import net.opengis.swe.v20.DataComponent;
import org.vast.ogc.OGCRegistry;
import org.vast.ows.OWSException;
import org.vast.ows.swe.SWEResponseWriter;
import org.vast.swe.SWEUtils;
import org.w3c.dom.*;
import org.vast.xml.DOMHelper;
import org.vast.xml.XMLWriterException;


/**
 * <p>
 * Writer to generate an XML DescribeTasking response based
 * on values contained in a DescribeTaskingResponse object for SPS v2.0
 * </p>
 *
 * @author Alex Robin <alex.robin@sensiasoftware.com>
 * @date Feb 29, 2008
 * */
public class DescribeTaskingResponseWriterV20 extends SWEResponseWriter<DescribeTaskingResponse>
{
    protected SWEUtils sweUtils = new SWEUtils(SWEUtils.V2_0);
	
	
	public Element buildXMLResponse(DOMHelper dom, DescribeTaskingResponse response, String version) throws OWSException
	{
		try
		{
			dom.addUserPrefix("sps", OGCRegistry.getNamespaceURI(SPSUtils.SPS, version));
			
			// root element
			Element rootElt = dom.createElement("sps:" + response.getMessageType());
			DataComponent params;
			Element componentElt;
			
			// write extensions
			writeExtensions(dom, rootElt, response);
            
			// common tasking parameters
			params = response.getTaskingParameters();
			if (params != null)
			{
				Element paramsElt = dom.addElement(rootElt, "sps:taskingParameters");
				dom.setAttributeValue(paramsElt, "name", params.getName());
				componentElt = sweUtils.writeComponent(dom, params, true);
				paramsElt.appendChild(componentElt);
			}
			else
				throw new SPSException("Tasking Parameters must be provided");
			
			return rootElt;
		}
		catch (XMLWriterException e)
		{
			throw new SPSException(e);
		}
	}
	
}