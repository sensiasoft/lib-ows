/***************************** BEGIN LICENSE BLOCK ***************************

The contents of this file are subject to the Mozilla Public License, v. 2.0.
If a copy of the MPL was not distributed with this file, You can obtain one
at http://mozilla.org/MPL/2.0/.

Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
for the specific language governing rights and limitations under the License.
 
Copyright (C) 2012-2015 Sensia Software LLC. All Rights Reserved.
 
******************************* END LICENSE BLOCK ***************************/

package net.opengis.fes.v20.impl;

import net.opengis.fes.v20.ComparisonOperator;
import net.opengis.fes.v20.ComparisonOperatorName;


/**
 * POJO class for XML type ComparisonOperatorType(@http://www.opengis.net/fes/2.0).
 *
 * This is a complex type.
 */
public class ComparisonOperatorImpl implements ComparisonOperator
{
    static final long serialVersionUID = 1L;
    protected ComparisonOperatorName name;
    
    
    public ComparisonOperatorImpl()
    {
    }
    
    
    /**
     * Gets the name property
     */
    @Override
    public ComparisonOperatorName getName()
    {
        return name;
    }
    
    
    /**
     * Sets the name property
     */
    @Override
    public void setName(ComparisonOperatorName name)
    {
        this.name = name;
    }
}