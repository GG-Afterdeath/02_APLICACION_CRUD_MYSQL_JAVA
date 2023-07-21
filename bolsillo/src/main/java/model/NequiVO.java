package model;

public class NequiVO {
    private int idNequi;
    private int saldo;
    private int telefono;

    
    public NequiVO() {
    }


    public NequiVO(int idNequi, int saldo, int telefono) {
        this.idNequi = idNequi;
        this.saldo = saldo;
        this.telefono = telefono;
    }


    public int getIdNequi() {
        return idNequi;
    }


    public void setIdNequi(int idNequi) {
        this.idNequi = idNequi;
    }


    public int getSaldo() {
        return saldo;
    }


    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }


    public int getTelefono() {
        return telefono;
    }


    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


    
}
