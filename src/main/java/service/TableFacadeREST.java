/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import SessionHandling.SessionHandler;
import beans.CafeTable;
import beans.Order;


import filters.PropertyFilterMixIn;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import managment.TablesMangment;
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
@Path("table")
public class TableFacadeREST {

//    static Logger log = Logger.getLogger(ItemFacadeREST.class.getName());
    @GET
    @Path("getAllTables")
    @Consumes("application/json")
    @Produces("application/json")
    public String getAllTables() {
//        log.info("------------------------------------------------------------");
//        log.info("start using  getAllItemsByCategoryId method in  ");
        String jsonString = null;
        SessionHandler shandler = new SessionHandler();
        Session session = shandler.openAndGetSession();
        try {
            TablesMangment tablesMangment = TablesMangment.getInstance();

            List<CafeTable> tables = tablesMangment.getAllTables(session);
            //  ObjectMappingToJson mappingClass = new ObjectMappingToJson();
            String[] FieldToBeMapped = {"tableId", "tableName","empty","lastOrder","orderId","voucherNumber","status"};

            if (tables != null) {
                //        jsonString = mappingClass.getJsonObjectFromObject(tables, FieldToBeMapped);
                // ____________________________________________________________________________ //

                ObjectMapper mapper = new ObjectMapper();
                mapper.getSerializationConfig().addMixInAnnotations(Object.class, PropertyFilterMixIn.class);
                FilterProvider filters = new SimpleFilterProvider().addFilter("filter fileds by name", SimpleBeanPropertyFilter.filterOutAllExcept(FieldToBeMapped));
                ObjectWriter writer = mapper.writer(filters);
                jsonString = writer.writeValueAsString(tables);

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

    @POST
    @Path("getTables")
    @Consumes("application/json")
    @Produces("application/json")
    public String getAllTablesWithCriteria(boolean empty) {
//        log.info("------------------------------------------------------------");
//        log.info("start using  getAllItemsByCategoryId method in  ");
        String jsonString = null;
        SessionHandler shandler = new SessionHandler();
        Session session = shandler.openAndGetSession();
        try {
            TablesMangment tablesMangment = TablesMangment.getInstance();

            List<CafeTable> tables = tablesMangment.getTablesWithCriteria(session, empty);
            //  ObjectMappingToJson mappingClass = new ObjectMappingToJson();
            String[] FieldToBeMapped = {"tableId", "tableName"};

            if (tables != null) {
                //        jsonString = mappingClass.getJsonObjectFromObject(tables, FieldToBeMapped);
                // ____________________________________________________________________________ //

                ObjectMapper mapper = new ObjectMapper();
                mapper.getSerializationConfig().addMixInAnnotations(Object.class, PropertyFilterMixIn.class);
                FilterProvider filters = new SimpleFilterProvider().addFilter("filter fileds by name", SimpleBeanPropertyFilter.filterOutAllExcept(FieldToBeMapped));
                ObjectWriter writer = mapper.writer(filters);
                jsonString = writer.writeValueAsString(tables);

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

    @POST
    @Path("getLatestOrder")
    @Consumes("application/json")
    @Produces("application/json")
    public String getLatestOrder(CafeTable table) {

        String jsonString = null;
        SessionHandler shandler = new SessionHandler();
        Session session = shandler.openAndGetSession();
        try {
            TablesMangment tablesMangment = TablesMangment.getInstance();

            Order order = tablesMangment.getLatestOrder(session, table.getTableId());
            //  ObjectMappingToJson mappingClass = new ObjectMappingToJson();
            String[] FieldToBeMapped = {"orderId", "voucherNumber", "orderlines"};
            // order.getOrderlines().forEach(orderLine->{orderLine.setOrder(null);});
            if (order != null) {
                //        jsonString = mappingClass.getJsonObjectFromObject(tables, FieldToBeMapped);
                // ____________________________________________________________________________ //

                ObjectMapper mapper = new ObjectMapper();
                 mapper.getSerializationConfig().addMixInAnnotations(Object.class, PropertyFilterMixIn.class);
                 FilterProvider filters = new SimpleFilterProvider().addFilter("filter fileds by name", SimpleBeanPropertyFilter.filterOutAllExcept(FieldToBeMapped));
                 ObjectWriter writer = mapper.writer(filters);
                jsonString = writer.writeValueAsString(order);
               // mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
               // mapper.enable(SerializationFeature.INDENT_OUTPUT);
               // mapper.writeValue(System.out, order);
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
