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

package org.vast.ows;


/**
 * <p>
 * Abstract base class for all objects representing OWS 
 * capabilities document. Sepcific services should derive
 * their LayerCapabilities object from this base class.
 * </p>
 *
 * @author Alex Robin <alex.robin@sensiasoftware.com>
 * @since Oct 31, 2005
 * */
public abstract class OWSLayerCapabilities extends OWSIdentification
{
	protected OWSServiceCapabilities parent;
	protected boolean enabled = true;
	    

    public OWSLayerCapabilities()
    {    	
    }


	public OWSServiceCapabilities getParent()
	{
		return parent;
	}


	public void setParent(OWSServiceCapabilities parent)
	{
		this.parent = parent;
	}
	
	
	public boolean isEnabled()
    {
        return enabled;
    }


    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }


    public String toString()
    {
    	return title;
    }
}