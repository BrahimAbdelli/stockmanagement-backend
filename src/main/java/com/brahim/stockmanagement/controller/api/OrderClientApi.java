package com.brahim.stockmanagement.controller.api;

import com.brahim.stockmanagement.dto.OrderClientDto;
import com.brahim.stockmanagement.dto.OrderClientDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.brahim.stockmanagement.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/orderclient")
@Api(APP_ROOT + "/orderclient")
public interface OrderClientApi {
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Save an order", notes = "This method allows you to save or update an order", response = OrderClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The order object has been created/modified"),
            @ApiResponse(code = 400, message = "The order object is not valid")
    })
    OrderClientDto save(@RequestBody OrderClientDto dto);

    @GetMapping(value = "/{idOrderClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search an order by ID", notes = "This method allows you to search an order by its ID", response = OrderClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The order wasn't found"),
            @ApiResponse(code = 404, message = "No order with this ID has been found")
    })
    OrderClientDto findById(@PathVariable("idOrderClient") Integer id);

    @GetMapping(value ="/filter/{codeorder}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search an order by CODE", notes = "This method allows you to search an order by its CODE", response =
            OrderClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The order wasn't found"),
            @ApiResponse(code = 404, message = "No order with this CODE has been found")
    })
    OrderClientDto findByCode(@PathVariable("codeOrder") String code);

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Returns the list of orders", notes = "This method allows you to search and return the list of orders ", responseContainer = "List<orderDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The list of orders / Empty list")
    })
    List<OrderClientDto> findAll();

    @DeleteMapping(value ="/{idOrderClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete an order", notes = "This method allows you to delete an order by its ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The order has been deleted")
    })
    void delete(@PathVariable("idOrderClient") Integer id);
}
