package api;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import entities.Exercise;

@RequestScoped
@Path("/exercise")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class ExerciseController {
	
	
	@GET
	public Response get() {
		List<Exercise> entities = services.ExerciseService.selectAll();
		return Response.ok(entities).build();
	}
	
}
