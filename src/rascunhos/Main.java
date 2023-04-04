package rascunhos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[]args) throws IOException {
            new CancelaEletronica();
            }
            }

    abstract class Transportes {
    private int qtdPessoas;
    private int qtdTransportes;

    public int getQtdPessoas(){
            return qtdPessoas;
            }

    public void setQtdPessoas(int pessoas){
            this.qtdPessoas+=pessoas;
            }

    public int getQtdTransportes(){
            return qtdTransportes;
            }

    public void setQtdTransportes(int transportes){
            this.qtdTransportes+=transportes;
            }
            }

    class CancelaEletronica extends Transportes{

    public CancelaEletronica() throws IOException {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String linha;

            try{
            while((linha=br.readLine())!=null){
            String[]partes=linha.split(" ");
            String comando=partes[0];
            int n=Integer.parseInt(partes[1]);

            if(comando.equals("ABEND")){
            break;
            }else if(comando.equals("VUELTA")){
            entrada(n);
            }else if(comando.equals("SALIDA")){
            saida(n);
            }
            }
            relatorio(getQtdPessoas(),getQtdTransportes());
            }catch(IOException e){
            e.printStackTrace();
            }finally{
            try{
            br.close();
            }catch(IOException e){
            e.printStackTrace();
            }
            }
            }

    public void relatorio(int pessoas,int transportes){
            System.out.println(Math.abs(pessoas));
            System.out.println(Math.abs(transportes));
            }

    public void entrada(int pessoas){
            this.setQtdPessoas(pessoas);
            this.setQtdTransportes(1);
            }

    public void saida(int pessoas){
            this.setQtdPessoas(-pessoas);
            this.setQtdTransportes(-1);
            }
            }
