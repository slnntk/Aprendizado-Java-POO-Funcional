package estruturadedados.x;

import java.util.LinkedList;
import java.util.Queue;

class No {
    int dado;
    No esquerda;
    No direita;

    public No(int dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria(int dado) {
        this.raiz = new No(dado);
    }

    // Percurso em ordem simétrica (In-Order)
    public void percursoSimetrico(No no) {
        if (no == null) {
            return;
        }
        percursoSimetrico(no.esquerda);
        System.out.print(no.dado + " ");
        percursoSimetrico(no.direita);
    }

    // Percurso em PÓS-ORDEM
    public void percursoPosOrdem(No no) {
        if (no == null) {
            return;
        }
        percursoPosOrdem(no.esquerda);
        percursoPosOrdem(no.direita);
        System.out.print(no.dado + " ");
    }

    // Altura da árvore
    public int altura(No no) {
        if (no == null) {
            return 0;
        } else {
            int alturaEsquerda = altura(no.esquerda);
            int alturaDireita = altura(no.direita);

            if (alturaEsquerda > alturaDireita) {
                return alturaEsquerda + 1;
            } else {
                return alturaDireita + 1;
            }
        }
    }

    // Percurso em Nível
    public void percursoNivel(No no) {
        if (no == null) {
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(no);

        while (!fila.isEmpty()) {
            No noAtual = fila.poll();
            System.out.print(noAtual.dado + " ");

            if (noAtual.esquerda != null) {
                fila.add(noAtual.esquerda);
            }

            if (noAtual.direita != null) {
                fila.add(noAtual.direita);
            }
        }
    }

    // Percurso em PRÉ-ORDEM
    public void percursoPreOrdem(No no) {
        if (no == null) {
            return;
        }
        System.out.print(no.dado + " ");
        percursoPreOrdem(no.esquerda);
        percursoPreOrdem(no.direita);
    }
}

class ArvoreBinariaBusca extends ArvoreBinaria {

    public ArvoreBinariaBusca(int dado) {
        super(dado);
    }

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.dado) {
            no.esquerda = inserirRec(no.esquerda, valor);
        } else if (valor > no.dado) {
            no.direita = inserirRec(no.direita, valor);
        }

        return no;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(No no, int valor) {
        if (no == null) {
            return false;
        }

        if (no.dado == valor) {
            return true;
        }

        if (valor < no.dado) {
            return buscarRec(no.esquerda, valor);
        } else {
            return buscarRec(no.direita, valor);
        }
    }

    public int minimo() {
        return encontrarMinimo(raiz).dado;
    }

    private No encontrarMinimo(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    public int maximo() {
        return encontrarMaximo(raiz).dado;
    }

    private No encontrarMaximo(No no) {
        while (no.direita != null) {
            no = no.direita;
        }
        return no;
    }

    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    private No removerRec(No no, int valor) {
        if (no == null) {
            return no;
        }

        if (valor < no.dado) {
            no.esquerda = removerRec(no.esquerda, valor);
        } else if (valor > no.dado) {
            no.direita = removerRec(no.direita, valor);
        } else {
            if (no.esquerda == null) {
                return no.direita;
            } else if (no.direita == null) {
                return no.esquerda;
            }

            no.dado = encontrarMinimo(no.direita).dado;
            no.direita = removerRec(no.direita, no.dado);
        }

        return no;
    }
}

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca(7);
        arvore.inserir(18);
        arvore.inserir(14);

        System.out.println("Raiz: " + arvore.raiz.dado);

        if (arvore.raiz.direita != null) {
            System.out.println("Direita da Raiz: " + arvore.raiz.direita.dado);
        } else {
            System.out.println("Não há nó à direita da Raiz.");
        }

        if (arvore.raiz.esquerda != null) {
            System.out.println("Esquerda da Raiz: " + arvore.raiz.esquerda.dado);
        } else {
            System.out.println("Não há nó à esquerda da Raiz.");
        }

        System.out.print("Percurso em Ordem Simétrica (In-Order): ");
        arvore.percursoSimetrico(arvore.raiz);
        System.out.println();

        System.out.print("Percurso em Pós-Ordem: ");
        arvore.percursoPosOrdem(arvore.raiz);
        System.out.println();

        System.out.print("Percurso em Pré-Ordem: ");
        arvore.percursoPreOrdem(arvore.raiz);
        System.out.println();

        System.out.println("Altura da árvore: " + arvore.altura(arvore.raiz));

        System.out.print("Percurso em Nível: ");
        arvore.percursoNivel(arvore.raiz);
        System.out.println();

        int valorBusca = 18;
        System.out.println("O valor " + valorBusca + " está presente na árvore? " + arvore.buscar(valorBusca));

        System.out.println("Valor mínimo na árvore: " + arvore.minimo());
        System.out.println("Valor máximo na árvore: " + arvore.maximo());

        int valorRemover = 18;
        arvore.remover(valorRemover);
        System.out.print("Percurso em Ordem Simétrica após remover " + valorRemover + ": ");
        arvore.percursoSimetrico(arvore.raiz);
        System.out.println();
    }
}
