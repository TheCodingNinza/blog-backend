package com.saurabhsameer.endpoints;

import com.saurabhsameer.endpoints.mapper.PostMapper;
import com.saurabhsameer.endpoints.requests.PostRequest;
import com.saurabhsameer.endpoints.response.PostResponse;
import com.saurabhsameer.services.PostService;
import jakarta.annotation.Resource;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;


@Component
@Path("/post")
public class PostResource {

    @Resource
    private PostService postService;

    @GET
    @Path("/{postId}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getPost(final @PathParam("postId") Long postId) {
        PostResponse postResponse = PostMapper.Mapper.fromPost(postService.getPostById(postId));
        return Response.status(Response.Status.OK)
                .entity(postResponse)
                .build();
    }

    @DELETE
    @Path("/{postId}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response deletePost(final @PathParam("postId") Long postId) {
        postService.deletePost(postId);
        return Response.status(Response.Status.OK)
                .build();
    }

    @PUT
    @Path("/{postId}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response updatePost(final PostRequest postRequest, final @PathParam("postId") Long postId) {
        postRequest.setPostId(postId);
        PostResponse postResponse = PostMapper.Mapper.fromPost(postService.updatePost(PostMapper.Mapper.fromPostRequest(postRequest)));
        return Response.status(Response.Status.OK)
                .entity(postResponse)
                .build();

    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response createPost(final PostRequest postRequest){
        PostResponse postResponse = PostMapper.Mapper.fromPost(postService.createPost(PostMapper.Mapper.fromPostRequest(postRequest)));
        return Response.status(Response.Status.OK)
                .entity(postResponse)
                .build();
    }

}
