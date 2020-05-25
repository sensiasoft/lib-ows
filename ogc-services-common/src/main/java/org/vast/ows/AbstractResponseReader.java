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

package org.vast.ows;

import org.vast.util.DateTimeFormat;
import org.vast.xml.DOMHelper;
import org.vast.xml.DOMHelperException;

import java.io.InputStream;


/**
 * <p>
 * Provides methods to parse an XML OWS response and
 * create an OWSResponse object
 * </p>
 *
 * @author Alex Robin
 * @since Nov 4, 2005
 * * @param <ResponseType> Type of OWS response object generated by this reader
 */
public abstract class AbstractResponseReader<ResponseType extends OWSResponse> implements OWSResponseReader<ResponseType>
{
    protected static final String READ_ERROR_MSG = "Cannot read ";
    protected static final String invalidResp = "Invalid Response";
	protected static final String invalidXML = "Invalid XML Response";
	
	protected DateTimeFormat timeFormat = new DateTimeFormat();
	
    
    public ResponseType readXMLResponse(InputStream input) throws OWSException
	{
		try
		{
            DOMHelper dom = new DOMHelper(input, false);
			return readXMLResponse(dom, dom.getBaseElement());
		}
		catch (DOMHelperException e)
		{
			throw new OWSException("Cannot read XML response", e);
		}
	}
}