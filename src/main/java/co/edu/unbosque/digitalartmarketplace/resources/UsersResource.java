package co.edu.unbosque.digitalartmarketplace.resources;

import co.edu.unbosque.digitalartmarketplace.jpa.entities.UserApp;
import co.edu.unbosque.digitalartmarketplace.resources.pojos.UserPOJO;
import co.edu.unbosque.digitalartmarketplace.services.UserAppService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("/users")
public class UsersResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(UserPOJO userPOJO) {

        UserAppService userAppService = new UserAppService();
        Optional<UserApp> userApp = userAppService.save(userPOJO.getEmail(), userPOJO.getPassword(), userPOJO.getName(), userPOJO.getRole());

        if (userApp.isPresent()) {
            return Response
                    .status(201)
                    .entity(userApp.get())
                    .build();
        } else {
            return Response
                    .serverError()
                    .build();
        }
    }

    @GET
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("email") String email) {

        UserAppService userAppService = new UserAppService();
        Optional<UserApp> userApp = userAppService.get(email);

        if (userApp.isPresent()) {

            return Response
                    .status(200)
                    .entity(userApp.get())
                    .build();
        } else {
            return Response
                    .status(404)
                    .build();
        }
    }

}