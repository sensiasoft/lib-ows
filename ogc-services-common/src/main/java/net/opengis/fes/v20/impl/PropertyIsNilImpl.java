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

import net.opengis.fes.v20.Expression;
import net.opengis.fes.v20.PropertyIsNil;


public class PropertyIsNilImpl extends ComparisonOpsImpl implements PropertyIsNil
{
    static final long serialVersionUID = 1L;
    protected Expression expression;
    protected String nilReason;
    
    
    public PropertyIsNilImpl()
    {
    }
    
    
    @Override
    public Expression getOperand()
    {
        return expression;
    }
    
    
    @Override
    public void setOperand(Expression expression)
    {
        this.expression = expression;
    }
    
    
    @Override
    public String getNilReason()
    {
        return nilReason;
    }
    
    
    @Override
    public boolean isSetNilReason()
    {
        return (nilReason != null);
    }
    
    
    @Override
    public void setNilReason(String nilReason)
    {
        this.nilReason = nilReason;
    }
}