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
    Alexandre Robin <robin@nsstc.uah.edu>
 
******************************* END LICENSE BLOCK ***************************/

package org.vast.ows.sos;

import org.vast.ows.AbstractCapabilitiesReader;
import org.vast.ows.OWSException;


/**
 * <p><b>Title:</b><br/>
 * SOS Capabilities Reader
 * </p>
 *
 * <p><b>Description:</b><br/>
 * Abstract SOS Capabilities Reader containing common code
 * for all versions
 * </p>
 *
 * <p>Copyright (c) 2006</p>
 * @author Alexandre Robin
 * @date Dec 20, 2006
 * @version 1.0
 */
public abstract class SOSCapabilitiesReader extends AbstractCapabilitiesReader
{
    
    @Override
    protected String buildQuery() throws OWSException
    {
        String url = null;
        url = this.server + "service=SOS&version=0.0.31&request=GetCapabilities";  
        return url;
    }
}