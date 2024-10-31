import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;

public class AppFrutas {
    public static void main(String[] args) {
        String localDoArquivo = "C:\\projects\\Facul\\Alest\\ALEST1.2024-2\\atividadepraentregar28-10-24\\src\\frutas.txt";

        ArvoreBinariaDeFrutas abf = new ArvoreBinariaDeFrutas();

        try (BufferedReader br = new BufferedReader(new FileReader(localDoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                abf.adicionar(linha);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + localDoArquivo);
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        System.out.println("Imprimindo em Arvore Binaria De Pesquisa:");
        abf.imprimirArvore();
        System.out.println();
        abf.ordemCentral();
        System.out.println("Imprimindo em Ordem Central:"+abf.getOrdemCentral());
        System.out.println();
        System.out.println("Imprimindo Altura:");
        System.out.println(abf.obterAltura());
        System.out.println();
        System.out.println("Imprimindo Tamanho:");
        System.out.println(abf.obterTamanho());

    }
     //e imprimir o conteúdo da árvore usando o caminhamento central com as 
     // bem como o tamanho e a altura da árvore.
//A ordem de inclusão na árvore é baseada na leitura do arquivo, linha a linha.


}