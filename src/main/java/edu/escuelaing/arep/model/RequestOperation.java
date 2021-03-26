package edu.escuelaing.arep.model;



public class RequestOperation {

    private String operation;
    private Double input;
    private Double output;

    public RequestOperation() {
    }

    /**
     * construcctor de la respuesta
     * @param op
     * @param input
     * @param output
     */
    public RequestOperation(String op, Double input, Double output) {
        this.operation = op;
        this.input = input;
        this.output = output;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getInput() {
        return input;
    }

    public void setInput(Double input) {
        this.input = input;
    }

    public Double getOutput() {
        return output;
    }

    public void setOutput(Double output) {
        this.output = output;
    }
}