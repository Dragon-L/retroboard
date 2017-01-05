package com.tw.retroboard.api;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/hi")
@Component
public class TryJersey extends BaseController {
    @GET
    public Response sayHi() {
        Map<String, String> ha = new HashMap<>();
        ha.put("hello", "gwz");
        return Response.ok(ha).build();
    }
}
