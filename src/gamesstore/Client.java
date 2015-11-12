/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesstore;

/**
 *
 * @author gabri
 */
public class Client implements RG, CPF {

    private String name;
    private String RG;
    private String CPF;

    @Override
    public int validateRG() {
        int numberChar = this.getRG().length();
        if (numberChar == 10) {
            return 1;
        }
        return 0;
    }

    @Override
    public int validateCPF() {
        int numberChar = this.getCPF().length();
        if (numberChar == 10) {
            return 1;
        }
        return 0;
    }

    /**
     * @return the nome
     */
    public String getName() {
        return name;
    }

    /**
     * @param nome the nome to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the RG
     */
    public String getRG() {
        return RG;
    }

    /**
     * @param RG the RG to set
     */
    public void setRG(String RG) {
        this.RG = RG;
    }

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
