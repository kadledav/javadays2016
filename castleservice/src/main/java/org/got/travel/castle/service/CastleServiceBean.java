package org.got.travel.castle.service;

import org.got.travel.castle.repo.CastleRepository;
import org.got.travel.castle.model.Castle;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

/**
 * CastleService implementation.
 * The implementation should provide an application busines logic.
 *
 * @author macalak@itexperts.sk
 *
 */
@Service
@Transactional(readOnly=true)
public class CastleServiceBean implements CastleService {
	final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CastleRepository castleRepository;

	@Override
	public List<Castle> getCastles() {
		LOG.info("Retrieving castles from catalog.");
		return castleRepository.findAll();
	}

}
