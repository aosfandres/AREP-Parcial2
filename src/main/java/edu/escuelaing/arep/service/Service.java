package edu.escuelaing.arep.service;

import edu.escuelaing.arep.model.RequestOperation;

public interface Service {
    
   /**
    * metodo que calcula la tangente
    * @param n
    * @return
    */
    RequestOperation getTan(Double n);

    /**
     * metodo que calcula el arcoseno
     * @param n
     * @return
     */
    RequestOperation getAsin(Double n);
}