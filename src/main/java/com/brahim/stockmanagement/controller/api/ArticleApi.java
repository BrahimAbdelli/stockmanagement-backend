package com.brahim.stockmanagement.controller.api;

import com.brahim.stockmanagement.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.brahim.stockmanagement.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "articles")
@Api(APP_ROOT + "/articles")
public interface ArticleApi {

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save an article", notes = "This method allows you to save or update an article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The article object has been created/modified"),
            @ApiResponse(code = 400, message = "The article object is not valid")
    })
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = "/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search an article by ID", notes = "This method allows you to search an article by its ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The article wasn't found"),
            @ApiResponse(code = 404, message = "No article with this ID has been found")
    })
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value ="/filter/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search an article by CODE", notes = "This method allows you to search an article by its CODE", response =
            ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The article wasn't found"),
            @ApiResponse(code = 404, message = "No article with this CODE has been found")
    })
    ArticleDto findByCode(@PathVariable("codeArticle") String code);

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns the list of articles", notes = "This method allows you to search and return the list of articles ", responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The list of articles / Empty list")
    })
    List<ArticleDto> findAll();

    @DeleteMapping(value ="/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete an article", notes = "This method allows you to delete an article by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The article has been deleted")
    })
    void delete(@PathVariable("idArticle") Integer id);
}
