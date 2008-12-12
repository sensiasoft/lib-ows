/***************************** BEGIN LICENSE BLOCK ***************************

The contents of this file are subject to the Mozilla Public License Version
1.1 (the "License"); you may not use this file except in compliance with
the License. You may obtain a copy of the License at
http://www.mozilla.org/MPL/MPL-1.1.html

Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
for the specific language governing rights and limitations under the License.

The Original Code is the "OGC Service Framework".

The Initial Developer of the Original Code is Spotimage S.A.
Portions created by the Initial Developer are Copyright (C) 2007
the Initial Developer. All Rights Reserved.

Contributor(s): 
   Alexandre Robin <alexandre.robin@spotimage.fr>

******************************* END LICENSE BLOCK ***************************/

package org.vast.ows.sps;

import org.vast.sweCommon.SWEData;


/**
 * <p><b>Title:</b><br/>
 * Status Report
 * </p>
 *
 * <p><b>Description:</b><br/>
 * 
 * </p>
 *
 * <p>Copyright (c) 2008</p>
 * @author Alexandre Robin <alexandre.robin@spotimage.fr>
 * @date Feb 25, 2008
 * @version 1.0
 */
public class StatusReport extends AbstractReport
{
	public static final String IN_PROGRESS = "other:IN_PROGRESS";
	public static final String CANCELLED = "CANCELLED";
	public static final String FAILED = "FAILED";
	public static final String COMPLETED= "COMPLETED";
	
	protected SWEData extendedData;


	public SWEData getExtendedData()
	{
		return extendedData;
	}


	public void setExtendedData(SWEData extendedData)
	{
		this.extendedData = extendedData;
	}
}
