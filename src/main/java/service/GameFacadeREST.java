/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import SessionHandling.SessionHandler;
import beans.Game;
import filters.PropertyFilterMixIn;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import managment.GameMangment;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.hibernate.Session;

/**
 *
 * @author < abdelrhman el_hadidy >
 */
@Path("game")
public class GameFacadeREST {

    //    static Logger log = Logger.getLogger(ItemFacadeREST.class.getName());
    @POST
    @Path("getAllGames")
    @Consumes("application/json")
    @Produces("application/json")
    public String getAllGames() {
//        log.info("------------------------------------------------------------");
//        log.info("start using  getAllItemsByCategoryId method in  ");
        String jsonString = null;
        SessionHandler shandler = new SessionHandler();
        Session session = shandler.openAndGetSession();
        try {
            GameMangment gameMangment = GameMangment.getInstance();

            List<Game> games = gameMangment.getAllGames(session);
            //  ObjectMappingToJson mappingClass = new ObjectMappingToJson();
            String[] FieldToBeMapped = {"gameId", "gameName", "basePrice", "baseUnit"};

            if (games != null) {
                //        jsonString = mappingClass.getJsonObjectFromObject(items, FieldToBeMapped);
                // ____________________________________________________________________________ //

                ObjectMapper mapper = new ObjectMapper();
                mapper.getSerializationConfig().addMixInAnnotations(Object.class, PropertyFilterMixIn.class);
                FilterProvider filters = new SimpleFilterProvider().addFilter("filter fileds by name", SimpleBeanPropertyFilter.filterOutAllExcept(FieldToBeMapped));
                ObjectWriter writer = mapper.writer(filters);
                jsonString = writer.writeValueAsString(games);

                // ____________________________________________________________________________ //
            } else {
                jsonString = "{\"result\":\" user was Not Saved \"}";
            }
            shandler.closeSessionAndCommite(session);

        } catch (Exception ex) {

            jsonString = "{\"result\":\" user was Not Saved \"}";
            System.out.println(ex.getMessage());
//            log.error(ex);
            shandler.roleBackAndCloseSession(session);
        }
        return jsonString;
    }

}
