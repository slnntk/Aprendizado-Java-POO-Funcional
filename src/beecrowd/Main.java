package beecrowd;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Tamanho máximo da Memória Principal = 2^(16)
        int memorySize = (int) Math.pow(2, 16);
        int cacheSize = (int) Math.pow(2, 16);
        int blockSize = (int) Math.pow(2, 16);
        CPU cpu = new CPU(memorySize, blockSize);
        MainMemory mainMemory = new MainMemory(memorySize);
        mainMemory.setBlockSize(blockSize);
        mainMemory.fillMemory();
        System.out.println(mainMemory.toString());
        Cache cache = new Cache(cacheSize, blockSize);
        System.out.println(cache.toString());
        TagDirectory tagDirectory = new TagDirectory();
        tagDirectory.setLines(cache.getSize() / mainMemory.getBlockSize());
        CacheController cacheController = new CacheController(mainMemory, cache, tagDirectory);

        for (int i=0; i < 10; i++) {
            cpu.setPC();
            cpu.setEAX(cacheController.getData(cpu.getPC()));
            System.out.println(cache.toString());
            System.out.println(String.format("EAX value: %s", cpu.getEAX()));
        }
    }
}
class TagDirectory {
    int lines;
    int directory[];
    public TagDirectory() {}

    public void setLines(int lines) {
        this.lines = lines;
        this.directory = new int[lines];
        for (int i = 0; i < this.directory.length; i++) {
            this.directory[i] = -1;
        }
    }

    public int getTag(int line) {
        return directory[line];
    }

    public void setTag(int line, int tag) {
        this.directory[line] = tag;
    }
}


class MainMemory {
    int size;
    int blockSize;
    String memory[];

    public MainMemory(int size) {
        this.size = size;
        this.memory = new String[size];

    }
    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public void fillMemory() {
        for (int i = 0; i < this.memory.length; i++) {
            this.memory[i] = Integer.toString(i);
            if (this.memory[i].length() == 1) {
                this.memory[i] = "0" + this.memory[i];
            }
        }
    }
    public int getSize() {
        return size;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public String getData(int address) {
        return this.memory[address];
    }

    public String toString() {
        String memory = "";
        for (int i = 0; i < this.size; i++) {
            memory += "[";
            for (int j = 0; j < this.blockSize - 1; j ++) {
                memory += String.format("%s, ",this.getData(i));
                i++;
            }
            memory += String.format("%s]",this.getData(i));
            if (i < this.size - this.blockSize) {
                memory += "\n";
            }
        }
        return memory;
    }
}

class CacheController {
    int tagSize;
    int lineSize;
    int offsetSize;
    int addressMask;
    int tagMask;
    int lineMask;
    int offsetMask;
    MainMemory mainMemory;
    Cache cache;
    TagDirectory tagDirectory;

    public CacheController(MainMemory mainMemory, Cache cache, TagDirectory tagDirectory) {
        this.mainMemory = mainMemory;
        this.cache = cache;
        this.tagDirectory = tagDirectory;

        /*
            Nessa parte, é interessante você inicializar o valor valor dos tamanhos da tag, linha  e offset.
            Para tanto, substitua a variável "valor" pelo valor apropriado.

             Obs: Utilize os métodos mainMemory.getSize(), cache.getSize() e mainMemory.getBlockSize() para
                  obter os tamanhos da memória principal, cache e do offset respectivamente
        */

        this.tagSize = calcLog2(mainMemory.getSize() / cache.getSize());
        this.lineSize = calcLog2(cache.getSize() / mainMemory.getBlockSize());
        this.offsetSize = calcLog2(mainMemory.getBlockSize());

        /*
            Nessa parte, você irá chamar os métodos abaixo para inicializar as máscaras de bits apropriadas.
            Essas máscaras serão úteis para obter os bits referentes às tags, linhas,  offsets e endereço
            propriamente dito.
        */

        this.setTagMask();
        this.setOffsetMask();
        this.setLineMask();
        this.setAddressMask();

    }

    public int calcLog2(int value) {
        /*
            Calcula o logarítmo na base 2 de valor e retorna o valor inteiro apropriado
        */
        return (int) (Math.log(value) / Math.log(2));
    }

    public int getTag(int address) {
        /*
           Obtém o valor do inteiro obtido dos bits da tag
        */

        int value = address >>> (this.lineSize + this.offsetSize);
        return value;
    }

    public int getLine(int address) {
        /*
           Obtém o valor do inteiro obtido dos bits da linha
        */
        int value = this.lineMask & address;
        value = value >>> (this.offsetSize);
        return value;
    }

    public int getOffset(int address) {
        /*
           Obtém o valor do inteiro obtido dos bits de offset
        */
        return this.offsetMask & address;
    }

    public void setTagMask() {
        /*
           Calcula a máscara de bits da tag.
           E.g. tamanho do endereço 6 bits, tamanho da tag 2 bits:
           máscara de tag: 110000
        */
        this.tagMask = (this.mainMemory.getSize() / this.cache.getSize()) - 1;
        this.tagMask = this.tagMask << (this.lineSize + this.offsetSize);
    }

    public void setOffsetMask() {
        /*
           Calcula a máscara de bits do offset.
           E.g. tamanho do endereço 6 bits, tamanho do offset 2 bits:
           máscara de tag: 000011
        */
        this.offsetMask = this.mainMemory.getBlockSize() - 1;
    }

    public void setLineMask() {
        /*
           Calcula a máscara de bits da linha.
           E.g. tamanho do endereço 6 bits, tamanho do offset 2 bits:
           máscara de tag: 001100
        */
        this.lineMask = (this.cache.getSize() / this.mainMemory.getBlockSize()) - 1;
        this.lineMask = this.lineMask << this.offsetSize;
    }

    public void setAddressMask() {
        /*
           Calcula a máscara de bits de endereço.
           E.g. Estamos utilizando int (32 bits), tamanho do endereço 6 bits:
           máscara de endereço: 000000000000000000000000111111
        */
        this.addressMask = this.mainMemory.getSize() - 1;
    }

    public String getData(int address) {
        int line = getLine(address);
        int tag = getTag(address);
        if (this.tagDirectory.getTag(line) == tag) {
            System.out.println("Tag Hit!");
            System.out.println(String.format("Cache line %d: %s", line, Arrays.toString(cache.getLine(getLine(address)))));
        }
        else {
            System.out.println("Tag Miss!");
            /*
              Nessa parte, como a tab não foi encontrada no dirertório de tags, você deve
              copiar os valores do bloco apropriado da memória para a linha correta da
              memória cache e atualizar o diretório de tags.
            */
            System.out.println(String.format("Mapping address %d (and neighbors) to line %d...", address, line));
            for (int i = 0; i < mainMemory.getBlockSize(); i++) {
                this.cache.setCache(this.getLine(address), i, mainMemory.getData((address & ~offsetMask) + i));
                this.tagDirectory.setTag(this.getLine(address), this.getTag(address));
            }
//            System.out.println(String.format("New cache line %d: %s", line, Arrays.toString(cache.getLine(getLine(address)))));
        }
        return cache.getLine(getLine(address))[getOffset(address)];
    }
}

class Cache {
    int lines;
    int size;
    String cache[][];

    public Cache(int size, int blockSize) {
        this.size = size;
        this.lines = size / blockSize;
        this.cache = new String[this.lines][blockSize];
    }

    public String[] getLine(int line) {
        return this.cache[line];
    }

    public int getSize() {
        return this.size;
    }

    public void setCache(int line, int offset, String value) {
        this.cache[line][offset] = value;
    }

    public String toString() {
        String memory = "";
        for (int i = 0; i < this.lines; i++) {
            memory += Arrays.toString(this.getLine(i));
            if (i < this.lines - 1) {
                memory += "\n";
            }
        }
        return memory;
    }
}

class CPU {
    int blockSize;
    int PC;
    String EAX;
    int size;

    public CPU(int size, int blockSize) {
        this.size = size;
        this.blockSize = blockSize;
    }

    public void setPC() {
        Random rdm = new Random();
        this.PC = rdm.nextInt(this.size - 1);
    }

    public void setEAX(String val) { this.EAX = val; }
    public int getPC() {
        return this.PC;
    }
    public String getEAX() { return EAX; }
}