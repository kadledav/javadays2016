package org.got.travel.castle.service;

import org.got.travel.castle.model.Castle;

import java.util.List;

/**
 * CastleService interface.
 * The implementation should provide an application busines logic.
 *
 * @author macalak@itexperts.sk
 *
 */
public interface CastleService {
	
	List<Castle> getCastles();

}
