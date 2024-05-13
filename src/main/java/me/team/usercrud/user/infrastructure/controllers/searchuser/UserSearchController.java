package me.team.usercrud.user.infrastructure.controllers.searchuser;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import me.team.usercrud.shared.domain.Mapper;
import me.team.usercrud.shared.domain.criteria.Criteria;
import me.team.usercrud.shared.domain.criteria.Order;
import me.team.usercrud.shared.infrastructure.controllers.criteria.CriteriaPrimitive;
import me.team.usercrud.user.application.criteria.UserCriteriaService;
import me.team.usercrud.user.domain.User;
import me.team.usercrud.user.infrastructure.controllers.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserSearchController {
    private final UserCriteriaService userCriteriaService;
    private final Mapper<User, UserRequest> userMapper;
    private final Mapper<CriteriaPrimitive, Criteria> criteriaMapper;
    
    public UserSearchController(
        UserCriteriaService userCriteriaService,
        Mapper<User, UserRequest> userMapper,
        Mapper<CriteriaPrimitive, Criteria> criteriaMapper
    ) {
        this.userCriteriaService = userCriteriaService;
        this.userMapper = userMapper;
        this.criteriaMapper = criteriaMapper;
    }
    
    @Operation(
        summary = "Search a User",
        description = """
            Search User, based on a criteria.
            
            Features : Filters, OrderBy, Pagination.
            
            Default Values:
                Page Size: 20
                Page: 0
                Filters: No Filters
                Order: No Order
                
            Special Characters (Obligatory Encoding):
                '[' -> %5B
                ']' -> %5D
                
            Request Format/s
            
            **WARNING** : Try Out feature not work because of encoding
            
            localhost/users/search?order.orderBy=name&order.orderType=DESC&filters[0].field=name&filters[0].operator=EQUAL&filters[0].value=Andreu2&page=0&size=1
            """,
        responses = {
            @ApiResponse(
                description = "Success",
                responseCode = "200",
                useReturnTypeSchema = true
            ),
            @ApiResponse(
                description = "Bad Request",
                responseCode = "400",
                content = @Content(
                    mediaType = "application/problem+json",
                    schema = @Schema(implementation = ProblemDetail.class)
                )
            )
        },
        tags = {"User"}
    )
    @GetMapping("/users/search")
    public Page<UserRequest> search(CriteriaPrimitive criteriaRequest) {
        var criteria = criteriaMapper.map(criteriaRequest);
        
        var pageable = createPageRequest(criteria.order(), criteriaRequest.getPage(), criteriaRequest.getSize());
        
        var users = userCriteriaService.search(criteria, pageable);
        
        return users.map(userMapper::map);
    }
    
    public Pageable createPageRequest(Optional<Order> optionalOrder, Integer pageNumber, Integer pageSize) {
        Sort sort = Sort.unsorted();
        
        if (optionalOrder.isPresent()) {
            var order = optionalOrder.get();
            
            if ("ASC".equalsIgnoreCase(order.orderType().toString())) {
                sort = Sort.by(order.orderBy().toString()).ascending();
            } else if ("DESC".equalsIgnoreCase(order.orderType().toString())) {
                sort = Sort.by(order.orderBy().toString()).descending();
            }
        }
        
        if (pageNumber == null) {
            pageNumber = 0;
        }
        
        if (pageSize == null) {
            pageSize = 20;
        }
        
        return PageRequest.of(pageNumber, pageSize, sort);
    }
}
