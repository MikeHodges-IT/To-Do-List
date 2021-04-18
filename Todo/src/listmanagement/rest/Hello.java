package listmanagement.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class Hello {
    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
         return  "Success  # 3";
    }

    
}
