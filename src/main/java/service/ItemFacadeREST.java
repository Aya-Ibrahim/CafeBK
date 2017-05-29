/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import SessionHandling.SessionHandler;
import beans.Item;
import beans.Service;
import filters.PropertyFilterMixIn;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import managment.ItemManagment;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.hibernate.Session;

/**
 *
 * @author fe
 */
//@Stateless
@Path("item")
public class ItemFacadeREST {

//    static Logger log = Logger.getLogger(ItemFacadeREST.class.getName());
    @POST
    @Path("getAllItems")
    @Consumes("application/json")
    @Produces("application/json")
    public String getAllItemsByServiceId(Service service) {
//        log.info("------------------------------------------------------------");
//        log.info("start using  getAllItemsByCategoryId method in  ");
        String jsonString = null;
        SessionHandler shandler = new SessionHandler();
        Session session = shandler.openAndGetSession();
        try {
            ItemManagment itemManagment = ItemManagment.getInstance();

            List<Item> items = itemManagment.getAllItemsByServiceId(service, session);
            //  ObjectMappingToJson mappingClass = new ObjectMappingToJson();
            String[] FieldToBeMapped = {"itemId", "itemName", "sortOrder", "price"};

            if (items != null) {
                //        jsonString = mappingClass.getJsonObjectFromObject(items, FieldToBeMapped);
                // ____________________________________________________________________________ //

                ObjectMapper mapper = new ObjectMapper();
                mapper.getSerializationConfig().addMixInAnnotations(Object.class, PropertyFilterMixIn.class);
                FilterProvider filters = new SimpleFilterProvider().addFilter("filter fileds by name", SimpleBeanPropertyFilter.filterOutAllExcept(FieldToBeMapped));
                ObjectWriter writer = mapper.writer(filters);
                jsonString = writer.writeValueAsString(items);

                // ____________________________________________________________________________ //
            } else {
                jsonString = "{\"result\":\" user was Not Saved \"}";
            }
            shandler.closeSessionAndCommite(session);

        } catch (Exception ex) {

            jsonString = "{\"result\":\" user was Not Saved \"}";
            ex.printStackTrace();
//            log.error(ex);
            shandler.roleBackAndCloseSession(session);
        }
        return jsonString;
    }
}
