package utfpr.ct.dainf.if62c.avaliacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class ProcessaLancamentos {
    private BufferedReader reader;

    public ProcessaLancamentos(File arquivo) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(arquivo));
    }

    public ProcessaLancamentos(String path) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(path));
    }
    
    private String getNextLine() throws IOException {
        String linha;
        linha=reader.readLine();
            return linha;
        }
    
    
    private Lancamento processaLinha(String linha) {
    Integer conta;
    int dia;
    int mes;
    int ano;
    String descricao;
    Double valor;
    ano = Integer.parseInt(linha.substring(6, 10));
        
        mes = Integer.parseInt(linha.substring(10, 12));
        dia = Integer.parseInt(linha.substring(12, 14));
       conta= parseInt(linha.substring(0,6));
       descricao = linha.substring(14, 74).trim();
       valor= parseDouble(linha.substring(74, 86))/100;;
    Date d=new Date(ano,mes-1,dia);
    return new Lancamento(conta,d,descricao,valor);
    }
    
    private Lancamento getNextLancamento() throws IOException {
       String linha=getNextLine();
       
       if(linha!=null){
           return processaLinha(linha);
       }
       if(getNextLine()==null){
           return null;
       }
       return null;
    }
    
    public List<Lancamento> getLancamentos() throws IOException {
        List<Lancamento> l= new ArrayList<>();
       Lancamento a;
        while((a=getNextLancamento())!=null){
           l.add(a);
       }
        l.sort(new LancamentoComparator());
       reader.close();
       return l;
       
    }
    
}
