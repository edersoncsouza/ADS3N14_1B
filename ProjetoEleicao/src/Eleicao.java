/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author lhries
 */
public interface Eleicao extends Remote {
    public void votar(String nome) throws RemoteException;
    public ArrayList<String> getCandidatos() throws RemoteException;
    public ArrayList<Candidato> getResultado() throws RemoteException;

}
