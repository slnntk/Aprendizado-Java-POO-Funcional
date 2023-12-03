package lst;
class No {
    int valor;
    No proximo;

    public No(int valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class ListaCircular {
    private No inicio;
    private No fim;
    private int tam;

    public ListaCircular() {
        this.inicio = null;
        this.fim = null;
        this.tam = 0;
    }

    public void inserirNoInicio(int num) {
        No novo = new No(num);

        if (novo != null) {
            novo.proximo = inicio;
            inicio = novo;
            if (fim == null)
                fim = novo;
            fim.proximo = inicio;
            tam++;
        } else {
            System.out.println("Erro ao alocar memória!");
        }
    }

    public void inserirNoFim(int num) {
        No aux, novo = new No(num);

        if (novo != null) {
            novo.valor = num;

            if (inicio == null) {
                inicio = novo;
                fim = novo;
                fim.proximo = inicio;
            } else {
                fim.proximo = novo;
                fim = novo;
                novo.proximo = inicio;
            }
            tam++;
        } else {
            System.out.println("Erro ao alocar memória!");
        }
    }

    public void inserirOrdenado(int num) {
        No aux, novo = new No(num);

        if (novo != null) {
            novo.valor = num;
            if (inicio == null) {
                inserirNoInicio(num);
            } else if (novo.valor < inicio.valor) {
                inserirNoInicio(num);
            } else {
                aux = inicio;
                while (aux.proximo != inicio && novo.valor > aux.proximo.valor)
                    aux = aux.proximo;
                if (aux.proximo == inicio)
                    inserirNoFim(num);
                else {
                    novo.proximo = aux.proximo;
                    aux.proximo = novo;
                    tam++;
                }
            }
        } else {
            System.out.println("Erro ao alocar memória!");
        }
    }

    public No remover(int num) {
        No aux, remover = null;

        if (inicio != null) {
            if (inicio == fim && inicio.valor == num) {
                remover = inicio;
                inicio = null;
                fim = null;
                tam--;
            } else if (inicio.valor == num) {
                remover = inicio;
                inicio = remover.proximo;
                fim.proximo = inicio;
                tam--;
            } else {
                aux = inicio;
                while (aux.proximo != inicio && aux.proximo.valor != num)
                    aux = aux.proximo;
                if (aux.proximo.valor == num) {
                    if (fim == aux.proximo) {
                        remover = aux.proximo;
                        aux.proximo = remover.proximo;
                        fim = aux;
                    } else {
                        remover = aux.proximo;
                        aux.proximo = remover.proximo;
                    }
                    tam--;
                }
            }
        }

        return remover;
    }

    public No buscar(int num) {
        No aux = inicio;

        if (aux != null) {
            do {
                if (aux.valor == num)
                    return aux;
                aux = aux.proximo;
            } while (aux != inicio);
        }
        return null;
    }

    public void imprimir() {
        No no = inicio;
        System.out.print("\n\tLista tam " + tam + ": ");
        if (no != null) {
            do {
                System.out.print(no.valor + " ");
                no = no.proximo;
            } while (no != inicio);
            System.out.println("\nInicio: " + inicio.valor);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        lista.inserirNoFim(1);
        lista.inserirNoFim(2);
        lista.inserirNoFim(3);

        System.out.println("Lista circular:");
        lista.imprimir();

        lista.remover(2);

        System.out.println("Lista após remoção:");
        lista.imprimir();
    }
}
