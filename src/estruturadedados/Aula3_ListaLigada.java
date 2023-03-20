package estruturadedados;

class Programa{
    public static void main(String[] args) {

        LinkedLista lista = new LinkedLista();
        lista.addElemento("AC");
        lista.addElemento("BA");
        lista.addElemento("CE");
        lista.addElemento("DF");

        for(int i = 0;i < lista.getTamanho();i++){
            System.out.printf("[%d] %s%n", i,lista.get(i).getValor());
        }

    }
}

class LinkedLista{

    private Elemento primeiro;
    private Elemento utlimo;
    private int tamanho;

    public LinkedLista() {
        this.tamanho = 0;
    }

    public void addElemento(String valor){

        Elemento novoElemento = new Elemento(valor);

        if (this.primeiro == null && this.utlimo == null){
            this.primeiro = novoElemento;
            this.utlimo = novoElemento;
        }
        else{
            this.utlimo.setProximo(novoElemento);
            this.utlimo = novoElemento;
        }
        tamanho++;
    }

    public Elemento get(int indice){

        Elemento atual = this.primeiro;
        for (int i = 0;i < indice;i++){
            if (atual.getProximo() != null){
                atual = atual.getProximo();
            }
        }
        return atual;
    }

    public Elemento getPrimeiro() {
        return primeiro;
    }

    public Elemento getUtlimo() {
        return utlimo;
    }

    public int getTamanho() {
        return tamanho;
    }
}

class Elemento{

    private String valor;
    private Elemento proximo;

    public Elemento(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }
}