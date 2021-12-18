package com.brahim.stockmanagement.controller.api;

import com.brahim.stockmanagement.dto.CategoryDto;
import com.brahim.stockmanagement.dto.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.brahim.stockmanagement.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "categories")
@Api(APP_ROOT + "/categories")
public interface CategoryApi {

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save a category", notes = "This method allows you to save or update a category", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The category object has been created/modified"),
            @ApiResponse(code = 400, message = "The category object is not valid")
    })
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value = "/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search a category by ID", notes = "This method allows you to search a category by its ID", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The category wasn't found"),
            @ApiResponse(code = 404, message = "No category with this ID has been found")
    })
    CategoryDto findById(@PathVariable("idCategory") Integer id);

    @GetMapping(value = "/filter/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search a category by CODE", notes = "This method allows you to search a category by its CODE", response =
            CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The category wasn't found"),
            @ApiResponse(code = 404, message = "No category with this CODE has been found")
    })
    CategoryDto findByCode(@PathVariable("codeCategory") String code);

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns the list of categories", notes = "This method allows you to search and return the list of categories ", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The list of categories / Empty list")
    })
    List<CategoryDto> findAll();

    @DeleteMapping(value = "/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete a category", notes = "This method allows you to delete a category by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The category has been deleted")
    })
    void delete(@PathVariable("idCategory") Integer id);
}
