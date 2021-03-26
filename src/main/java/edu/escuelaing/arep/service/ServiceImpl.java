package edu.escuelaing.arep.service;

import edu.escuelaing.arep.model.RequestOperation;


public class ServiceImpl implements Service {

    @Override
    public RequestOperation getTan(Double n) { 
        Double res = Math.tan(n);
        return new RequestOperation("TAN", n, res);
    }

    @Override
    public RequestOperation getAsin(Double n) {
        Double res = Math.asin(n);
        return new RequestOperation("ASIN", n, res);
    }
}