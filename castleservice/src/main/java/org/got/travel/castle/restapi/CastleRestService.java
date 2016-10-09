package org.got.travel.castle.restapi;


import org.got.travel.castle.service.CastleService;
import org.got.travel.castle.model.Castle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * JAX-RS wrapper around CastleService.
 * If a Service just delegates handling to underlying Repository, consider
 * to use Spring Data Rest and directly expose a Repository to web layer.
 * 
 * @author macalak@itexperts.sk
 *
 */
@RestController
public class CastleRestService {
	final Logger LOG = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    CastleService castleService;
    
    @RequestMapping(produces={"application/json"}, value="/castle", method=RequestMethod.GET )
    public List<Castle> getCastles() {
    	LOG.info("Processing client request...");
        return castleService.getCastles();
    }
}
