package org.got.travel.gateway.castle.restapi;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 
 * @author macalak@itexperts.sk
 *
 */

@RestController
@RequestMapping("/gateway")
class CastleApiGateway {

    private final ReservationReader reservationReader;


    @Autowired
    public CastleApiGateway(ReservationReader reservationReader) {
        this.reservationReader = reservationReader;
    }

    public Collection<String> fallback() {
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(method = RequestMethod.GET, value = "/castlenames")
    public Collection<String> names() {
        return this.reservationReader
                .read()
                .getContent()
                .stream()
                .map(Castle::getName)
                .collect(Collectors.toList());
    }
}

@FeignClient("castleservice")
interface ReservationReader {
    @RequestMapping(method = RequestMethod.GET, value = "/api/castles")
    Resources<Castle> read();
}

class Castle {
    private String name;

    public String getName() {
        return name;
    }
}
