package com.grupo16.hackathon.domain;

public enum Estado {

	AC,
	AL,
	AP,
	AM,
	BA,
	CE,
	ES,
	GO,
	MA,
	MT,
	MS,
	MG,
	PA,
	PB,
	PR,
	PE,
	PI,
	RJ,
	RN,
	RS,
	RO,
	RR,
	SC,
	SP,
	SE,
	TO,
	DF;

	public static Estado getByOrdinal(int ordinal) {
		Estado[] values = values();
		return values[ordinal];
	}
}
