package com.example.fournisseurs.resources;

import com.example.fournisseurs.dao.Fr_dao;
import com.example.fournisseurs.models.Fournisseur;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("fournisseur")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FrResource {

    @Inject
    Fr_dao frDao;

    @GET
    public Response getAll() {
        return Response.ok(frDao.getAll()).build();
    }
    @GET
    @Path("{ville}")
    public Response getFournisseur(@PathParam("ville") String ville) {
        Fournisseur fournisseur = frDao.findByVille(ville);

        return Response.ok(fournisseur).build();
    }

    @POST
    public Response create(Fournisseur fournisseur) {
        frDao.create(fournisseur);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Fournisseur getFournisseur = frDao.findById(id);

        frDao.delete(getFournisseur);

        return Response.ok().build();
    }

}
