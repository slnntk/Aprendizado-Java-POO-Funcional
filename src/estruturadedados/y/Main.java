package estruturadedados.y;

public class Main {
    public static void main(String[] args) {
        Arvbin<Integer> a1 = new Arvbin<Integer>(1),
                a2 = new Arvbin<Integer>(2),
                a3 = new Arvbin<Integer>(3, a1, a2),
                a4 = new Arvbin<Integer>(4),
                a5 = new Arvbin<Integer>(5),
                a6 = new Arvbin<Integer>(6),
                a7 = new Arvbin<Integer>(7, a5, a6),
                a8 = new Arvbin<Integer>(8),
                a9 = new Arvbin<Integer>(9),
                a10 = new Arvbin<Integer>(10, a8, a9);

        a4.defineEsq(a3);
        a4.defineDir(a7);

        System.out.print("Estrutura inicial da árvore: ");
        a4.mostra();
        System.out.println();

        Arvbin<Integer> a11 = a4.busca(3);
        if (a11 != null) {
            a11.defineVal(11);
            a11.defineEsq(a10);
        }

        System.out.print("Estrutura da árvore após modificação: ");
        a4.mostra();
        System.out.println();

        System.out.println("Percurso em Pré-Ordem: ");
        a4.percursoPreOrdem();

        System.out.println("Percurso em Pós-Ordem: ");
        a4.percursoPosOrdem();

        System.out.println("Percurso em Ordem Simétrica (In-Order): ");
        a4.percursoSimetrico();
    }
}

class Arvbin<T extends Comparable<T>> {
    private T val;
    private Arvbin<T> esq, dir;

    public Arvbin(T valor) {
        val = valor;
        esq = null;
        dir = null;
    }

    public Arvbin(T valor, Arvbin<T> arvEsq, Arvbin<T> arvDir) {
        val = valor;
        esq = arvEsq;
        dir = arvDir;
    }

    public T retornaVal() {
        return val;
    }

    public Arvbin<T> retornaEsq() {
        return esq;
    }

    public Arvbin<T> retornaDir() {
        return dir;
    }

    public void defineVal(T valor) {
        val = valor;
    }

    public void defineEsq(Arvbin<T> filho) {
        esq = filho;
    }

    public void defineDir(Arvbin<T> filho) {
        dir = filho;
    }

    public void mostra() {
        System.out.print("(" + val);
        if (esq != null)
            esq.mostra();
        if (dir != null)
            dir.mostra();
        System.out.print(")");
    }

    public int calculaAltura() {
        if ((esq == null) && (dir == null))
            return 0;

        int altEsq = 0, altDir = 0;

        if (esq != null)
            altEsq = esq.calculaAltura();

        if (dir != null)
            altDir = dir.calculaAltura();

        return 1 + Math.max(altEsq, altDir);
    }

    public T calculaMaximo() {
        if ((esq == null) && (dir == null))
            return val;

        T maiorGeral, maiorEsq, maiorDir;

        if ((esq != null) && (dir == null)) {
            maiorGeral = esq.calculaMaximo();
        } else if ((esq == null) && (dir != null)) {
            maiorGeral = dir.calculaMaximo();
        } else {
            maiorEsq = esq.calculaMaximo();
            maiorDir = dir.calculaMaximo();

            if (maiorEsq.compareTo(maiorDir) > 0)
                maiorGeral = maiorEsq;
            else
                maiorGeral = maiorDir;
        }

        if (maiorGeral.compareTo(val) > 0)
            return maiorGeral;

        return val;
    }

    public Arvbin<T> busca(T valor) {
        Arvbin<T> ret;

        if (valor.compareTo(val) == 0) {
            return this;
        }

        if (esq != null) {
            ret = esq.busca(valor);
            if (ret != null)
                return ret;
        }

        if (dir != null)
            return dir.busca(valor);
        return null;
    }

    public void percursoPreOrdem() {
        percursoPreOrdemRec(this);
        System.out.println();
    }

    private void percursoPreOrdemRec(Arvbin<T> no) {
        if (no != null) {
            System.out.print(no.val + " ");
            percursoPreOrdemRec(no.esq);
            percursoPreOrdemRec(no.dir);
        }
    }

    public void percursoPosOrdem() {
        percursoPosOrdemRec(this);
        System.out.println();
    }

    private void percursoPosOrdemRec(Arvbin<T> no) {
        if (no != null) {
            percursoPosOrdemRec(no.esq);
            percursoPosOrdemRec(no.dir);
            System.out.print(no.val + " ");
        }
    }

    public void percursoSimetrico() {
        percursoSimetricoRec(this);
        System.out.println();
    }

    private void percursoSimetricoRec(Arvbin<T> no) {
        if (no != null) {
            percursoSimetricoRec(no.esq);
            System.out.print(no.val + " ");
            percursoSimetricoRec(no.dir);
        }
    }
}
