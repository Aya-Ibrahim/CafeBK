/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;

/**
 *
 * @author < abdelrhman el_hadidy >
 */
public class MappingObjectToJson {

    static Logger log = Logger.getLogger(MappingObjectToJson.class.getName());

    /**
     *
     * @param object
     * @param Fieldnames it get list of fields which will be the only fields in
     * this object
     * @return json string with that object content
     * @throws IOException
     */
    public static String getJsonObjectFromObject(Object object, String[] Fieldnames) throws IOException {
        log.info("------------------------------------------------------------");
        log.info("start using  getJsonObjectFromObject method  ");
        String jsonString = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.getSerializationConfig().addMixInAnnotations(Object.class, PropertyFilterMixIn.class);
        FilterProvider filters = new SimpleFilterProvider().addFilter("filter fileds by name", SimpleBeanPropertyFilter.filterOutAllExcept(Fieldnames));
        ObjectWriter writer = mapper.writer(filters);
        jsonString = writer.writeValueAsString(object);
        return jsonString;
    }

    /**
     *
     * @param list
     * @param Fieldnames it get list of fields which will be the only fields in
     * this list of objects
     * @return json string with that list content
     * @throws IOException
     */
    public static String getJsonObjectFromObjectList(List<Object> list, String[] Fieldnames) throws IOException {
        log.info("------------------------------------------------------------");
        log.info("start using  getJsonObjectFromObjectList method  ");
        String jsonString = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.getSerializationConfig().addMixInAnnotations(Object.class, PropertyFilterMixIn.class);
        FilterProvider filters = new SimpleFilterProvider().addFilter("filter fileds by name", SimpleBeanPropertyFilter.filterOutAllExcept(Fieldnames));
        ObjectWriter writer = mapper.writer(filters);
        jsonString = writer.writeValueAsString(list);
        return jsonString;
    }

}
