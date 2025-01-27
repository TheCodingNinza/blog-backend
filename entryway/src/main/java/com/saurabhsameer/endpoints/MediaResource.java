package com.saurabhsameer.endpoints;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saurabhsameer.endpoints.mapper.MediaMapper;
import com.saurabhsameer.endpoints.requests.MediaRequest;
import com.saurabhsameer.endpoints.response.MediaResponse;
import com.saurabhsameer.services.MediaService;
import com.saurabhsameer.services.entities.Media;
import jakarta.annotation.Resource;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Component;

import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
@Path("/media")
public class MediaResource {

    @Resource
    private MediaService mediaService;

    @GET
    @Path("/{postId}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getMediaList(final @PathParam("postId") Long postId) {
        List<Media> mediaList = mediaService.getMedia(postId);
        return Response.status(Response.Status.OK)
                .entity(mediaList.stream().map(media
                        -> MediaMapper.MAPPER.fromMedia(media)).collect(Collectors.toList())).build();
    }

    @DELETE
    @Path("/{mediaId}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deleteMedia(final @PathParam("mediaId") Long mediaId) {
        System.out.println("mediaservice: "+mediaService);
        mediaService.deleteMedia(mediaId);
        return Response.status(Response.Status.OK)
              .build();
    }

    @PUT
    @Path("/{mediaId}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response updateMedia(final MediaRequest mediaRequest){
        MediaResponse mediaResponse = MediaMapper.MAPPER.fromMedia(
                mediaService.updateMedia(MediaMapper.MAPPER.fromMediaRequest(mediaRequest)));
        return Response.status(Response.Status.OK)
                .entity(mediaResponse)
                .build();

    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.MULTIPART_FORM_DATA)
    public Response createMedia(@FormDataParam("file") InputStream file, final @FormDataParam("mediaRequest") String mediaRequestString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        MediaRequest mediaRequest = objectMapper.readValue(mediaRequestString, MediaRequest.class);
       MediaResponse mediaResponse = MediaMapper.MAPPER.fromMedia(mediaService.createMedia(file, MediaMapper.MAPPER.fromMediaRequest(mediaRequest), mediaRequest.getFormat()));
        return Response.status(Response.Status.OK)
                .entity(mediaResponse)
                .build();

    }
}
