package estruturadedados.z;

class No {
    int valor, altura;
    No esquerda, direita;

    public No(int valor) {
        this.valor = valor;
        this.altura = 1;
        this.esquerda = this.direita = null;
    }
}

class ArvoreAVL {
    No raiz;

    private int altura(No no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    private int getBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esquerda) - altura(no.direita);
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        } else {
            return no; // Não permitir elementos duplicados
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int balanceamento = getBalanceamento(no);

        // Casos de rotação
        if (balanceamento > 1 && valor < no.esquerda.valor) {
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && valor > no.direita.valor) {
            return rotacaoEsquerda(no);
        }
        if (balanceamento > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && valor < no.direita.valor) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }
        return no;
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private No removerRecursivo(No no, int valor) {
        if (no == null) {
            return no;
        }

        if (valor < no.valor) {
            no.esquerda = removerRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = removerRecursivo(no.direita, valor);
        } else {
            if (no.esquerda == null || no.direita == null) {
                No temp = null;
                if (temp == no.esquerda) {
                    temp = no.direita;
                } else {
                    temp = no.esquerda;
                }

                if (temp == null) {
                    temp = no;
                    no = null;
                } else {
                    no = temp;
                }
            } else {
                No temp = minimoValorNo(no.direita);
                no.valor = temp.valor;
                no.direita = removerRecursivo(no.direita, temp.valor);
            }
        }

        if (no == null) {
            return no;
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int balanceamento = getBalanceamento(no);

        // Casos de rotação após remoção
        if (balanceamento > 1 && getBalanceamento(no.esquerda) >= 0) {
            return rotacaoDireita(no);
        }
        if (balanceamento > 1 && getBalanceamento(no.esquerda) < 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && getBalanceamento(no.direita) <= 0) {
            return rotacaoEsquerda(no);
        }
        if (balanceamento < -1 && getBalanceamento(no.direita) > 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private No minimoValorNo(No no) {
        No atual = no;
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    public void percorrerEmOrdem() {
        percorrerEmOrdemRec(raiz);
    }

    private void percorrerEmOrdemRec(No no) {
        if (no != null) {
            percorrerEmOrdemRec(no.esquerda);
            System.out.print(no.valor + " ");
            percorrerEmOrdemRec(no.direita);
        }
    }
}

// Exemplo de utilização
public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();
        int[] valores = {9, 5, 10, 0, 6, 11, -1, 1, 2};

        for (int valor : valores) {
            arvore.inserir(valor);
        }

        System.out.println("Árvore AVL percorrida em ordem:");
        arvore.percorrerEmOrdem();

        arvore.remover(10);
        System.out.println("\nApós remover o valor 10:");
        arvore.percorrerEmOrdem();
    }
}
