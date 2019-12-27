package com.examples.web.sector_of_activity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SectorOfActivityNotFound extends RuntimeException {
}
