/*-
 * #%L
 * Alfresco Repository
 * %%
 * Copyright (C) 2005 - 2017 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software. 
 * If the software was purchased under a paid Alfresco license, the terms of 
 * the paid license agreement will prevail.  Otherwise, the software is 
 * provided under the following open source license terms:
 * 
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
package org.alfresco.repo.search.impl.solr.facet.facetsresponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A metric with one value
 */
public class ListMetric implements Metric
{
    private static Log logger = LogFactory.getLog(ListMetric.class);
    private final METRIC_TYPE type;
    private final Map<String, Object> value = new HashMap<>(1);

    public ListMetric(METRIC_TYPE type, Object val)
    {
        this.type = type;
        try
        {
            ArrayNode jsonArray = (ArrayNode) val;
            List<JsonNode> values = new ArrayList<>(jsonArray.size());
            for(int i = 0; i < jsonArray.size(); i++)
            {
                values.add(jsonArray.get(i));
            }
            value.put(type.toString(), values);
        }
        catch (ClassCastException cce)
        {
            logger.debug("ClassCastException for "+val);
        }
    }

    @Override
    public METRIC_TYPE getType()
    {
        return type;
    }

    @Override
    public Map<String, Object> getValue()
    {
        return value;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ListMetric that = (ListMetric) o;

        if (type != that.type)
            return false;
        if (!value.equals(that.value))
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = type.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
