/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sim.gls.eod.branch;

/**
 *
 * @author Levi Barasa
 */
public class OrigAfricException extends RuntimeException {

    private String tranId;

    public OrigAfricException() {

    }

    public OrigAfricException(String message, String tranId) {
        super(message);
        this.tranId = tranId;
    }

    public OrigAfricException(String message, String tranId, Throwable cause) {
        super(message, cause);
        this.tranId = tranId;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " for Transaction Id :" + tranId;
    }

    /**
     * @return the tranId
     */
    public String getTranId() {
        return tranId;
    }

    /**
     * @param tranId the tranId to set
     */
    public void setTranId(String tranId) {
        this.tranId = tranId;
    }

}
