package com.company.document.domain;

import java.util.Random;

import com.company.document.domain.random.RandomProcessDuration;

public class RealRandomProcessDuration implements RandomProcessDuration {

	@Override
	public int getNumber() {
		return new Random().nextInt(10);
	}

}
