/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppModel;

/**
 *
 * @author HenriqueLinhares
 */
public class Reserva {
private int id;
private String professorID;
private String idSalas;
private String horarioInicial;
private String horarioFinal;
private boolean aprovada;
private String data;

    public Reserva(int id, String professorID, String idSalas, String horarioInicial, String horarioFinal, boolean aprovada, String data) {
        this.id = id;
        this.professorID = professorID;
        this.idSalas = idSalas;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.aprovada = aprovada;
        this.data = data;
    }

    @Override
    public String toString() {
        
        String statusDeAprovacao;
        if (this.aprovada){
            statusDeAprovacao = "Aprovada";
        } else {
            statusDeAprovacao = "Nao Aprovada";
        }
        
        return id+" | "+professorID+" | "+idSalas+" | "+data+" | "+horarioInicial+" | "+horarioFinal+" | "+statusDeAprovacao;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessorID() {
        return professorID;
    }

    public void setProfessorID(String professorID) {
        this.professorID = professorID;
    }

    public String getIdSalas() {
        return idSalas;
    }

    public void setIdSalas(String idSalas) {
        this.idSalas = idSalas;
    }

    public String getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    
}
