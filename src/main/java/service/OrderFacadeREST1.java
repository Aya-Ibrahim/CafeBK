/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import SessionHandling.SessionHandler;
import beans.Item;
import beans.Order;
import beans.Service;
import filters.MappingObjectToJson;
import filters.PropertyFilterMixIn;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import managment.ItemManagment;
import managment.OrderManagment;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.hibernate.Session;

/**
 *
 * @author fe
 */
//@Stateless
@Path("order")
public class OrderFacadeREST1 {

//    static Logger log = Logger.getLogger(ItemFacadeREST.class.getName());
    @GET
    @Path("getAllFinishedOrder")
    @Consumes("application/json")
    @Produces("application/json")
    public String getAllFinishedOrder() {
//        log.info("------------------------------------------------------------");
//        log.info("start using  getAllItemsByCategoryId method in  ");
        String jsonString = null;
        SessionHandler shandler = new SessionHandler();
        Session session = shandler.openAndGetSession();
        try {
            OrderManagment orderManagment = OrderManagment.getInstance();

            List<Order> items = orderManagment.getAllFinishedOrder(session);

            // we should use the voucher no to show it in the front end
            String[] FieldToBeMapped = {"orderId", "cafeTable", "tableName", "tableId"};

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

    @POST
    @Path("serveOrder")
    @Consumes("application/json")
    @Produces("application/json")
    public String serveOrder(Order order) {
//        log.info("------------------------------------------------------------");
//        log.info("start using  getAllItemsByCategoryId method in  ");
        String jsonString = null;
        SessionHandler shandler = new SessionHandler();
        Session session = shandler.openAndGetSession();
        try {
            OrderManagment orderManagment = OrderManagment.getInstance();

            Boolean Served = orderManagment.serveOrder(order, session);
            jsonString = "{\"result\":\" " + Served + " \"}";
            shandler.closeSessionAndCommite(session);

        } catch (Exception ex) {
            jsonString = "{\"result\":\"false\"}";
            ex.printStackTrace();
            System.out.println(ex.getMessage());
//            log.error(ex);
            shandler.roleBackAndCloseSession(session);
        }
        return jsonString;
    }

    @POST
    @Path("getTableLastOrder")
    @Consumes("application/json")
    @Produces("application/json")
    public String getTableLastOrder(Order order) {
//        log.info("------------------------------------------------------------");
//        log.info("start using  getAllItemsByCategoryId method in  ");
        String jsonString = null;
        SessionHandler shandler = new SessionHandler();
        Session session = shandler.openAndGetSession();
        try {
            OrderManagment orderManagment = OrderManagment.getInstance();

            Order orderToSend = orderManagment.getTableLastOrder(order, session);
            String[] FieldToBeMapped = {"orderId", "cafeTable", "tableName", "tableId", "status",
                "orderlines", "orderlineId", "item", "itemId", "itemName","status", "quantity",
//                "orderlineAdditions", "orderAdditionId", "itemHasAddition", "addition", "addId", "addName", "quantity",
                "orderlineAdditions", "orderAdditionId", "itemHasAddition", "addition", "addId", "addName", "quantity",
                "gameLines", "gameLineId", "game", "gameId", "gameName", "period", "price", "startDate", "endDate"};
//
            if (orderToSend != null) {

                jsonString = MappingObjectToJson.getJsonObjectFromObject(orderToSend, FieldToBeMapped);
            } else {
                jsonString = "{\"result\":\"order not Found\"}";
            }

            shandler.closeSessionAndCommite(session);

        } catch (Exception ex) {
            jsonString = "{\"result\":\"order not Found\"}";
            ex.printStackTrace();
            System.out.println(ex.getMessage());
//            log.error(ex);
            shandler.roleBackAndCloseSession(session);
        }
        return jsonString;
    }

}
