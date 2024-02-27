package estruturadedados.xg;

class No {
    int valor;
    int altura;
    No esquerda, direita;

    public No(int valor) {
        this.valor = valor;
        this.altura = 1;
        this.esquerda = this.direita = null;
    }
}

class ArvoreAVL {
    No raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    // Obter a altura de um nó
    private int altura(No no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    // Obter o fator de balanceamento de um nó
    private int fatorBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esquerda) - altura(no.direita);
    }

    // Atualizar a altura de um nó
    private void atualizarAltura(No no) {
        if (no != null) {
            no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        }
    }

    // Rotacionar para a direita
    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        // Atualizar alturas
        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    // Rotacionar para a esquerda
    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        // Atualizar alturas
        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    // Inserir um valor na árvore AVL
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esquerda = inserirRec(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRec(no.direita, valor);
        } else {
            return no; // Ignorar valores duplicados
        }

        // Atualizar altura do nó atual
        atualizarAltura(no);

        // Obter o fator de balanceamento deste nó para verificar se é necessário balancear
        int fatorBal = fatorBalanceamento(no);

        // Casos de balanceamento
        // Caso Esquerda-Esquerda
        if (fatorBal > 1 && valor < no.esquerda.valor) {
            return rotacaoDireita(no);
        }
        // Caso Direita-Direita
        if (fatorBal < -1 && valor > no.direita.valor) {
            return rotacaoEsquerda(no);
        }
        // Caso Esquerda-Direita
        if (fatorBal > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        // Caso Direita-Esquerda
        if (fatorBal < -1 && valor < no.direita.valor) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    // Exibir a árvore em ordem
    public void exibirEmOrdem() {
        exibirEmOrdemRec(raiz);
        System.out.println();
    }

    private void exibirEmOrdemRec(No no) {
        if (no != null) {
            exibirEmOrdemRec(no.esquerda);
            System.out.print(no.valor + " ");
            exibirEmOrdemRec(no.direita);
        }
    }

    // Buscar um valor na árvore AVL
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No no, int valor) {
        if (no == null) {
            return false;
        }

        if (valor == no.valor) {
            return true;
        } else if (valor < no.valor) {
            return buscarRec(no.esquerda, valor);
        } else {
            return buscarRec(no.direita, valor);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        // Inserir valores na árvore AVL
        int[] valores = {10, 5, 15, 3, 7, 12, 20};
        for (int valor : valores) {
            arvore.inserir(valor);
        }

        // Exibir a árvore AVL em ordem
        System.out.println("Árvore AVL em ordem:");
        arvore.exibirEmOrdem();

        // Buscar valores na árvore AVL
        int valorBusca = 7;
        if (arvore.buscar(valorBusca)) {
            System.out.println("O valor " + valorBusca + " está presente na árvore AVL.");
        } else {
            System.out.println("O valor " + valorBusca + " não está presente na árvore AVL.");
        }
    }
}
