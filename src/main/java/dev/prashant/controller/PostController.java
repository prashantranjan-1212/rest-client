package dev.prashant.controller;

import dev.prashant.client.JsonPlaceHolderService;
import dev.prashant.post.Post;
import dev.prashant.service.PostService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/posts")
public class PostController {

    private final JsonPlaceHolderService postService;

    public PostController(JsonPlaceHolderService postService) {
        this.postService = postService;
    }

    @GetMapping()
    List<Post> findAll() {
        return  postService.findAll();
    }

    @GetMapping("/{id}")
    Post findById(@PathVariable Integer id) {
        return postService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping("/{id}")
    Post update(@RequestBody Post post, @PathVariable Integer id) {
        return postService.update(post, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable Integer id) {
        postService.delete(id);
    }
}
