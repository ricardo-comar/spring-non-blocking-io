package br.comar.ricardo.stuff.nio.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;

import br.comar.ricardo.stuff.nio.service.NIOService;

@Service
public class NIOServiceImpl implements NIOService {

	@Override
	public int veryExpensiveOperation(Integer minMs, Integer maxMs) {
		Integer sleep = new Random().ints(1, minMs, maxMs).iterator().next();
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
		}
		return sleep;
	}

}
