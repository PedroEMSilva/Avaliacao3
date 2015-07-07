package utfpr.ct.dainf.if62c.avaliacao;

import java.util.Comparator;
import java.util.Objects;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author 
 */
public class LancamentoComparator implements Comparator<Lancamento> {
    
    @Override
    public int compare(Lancamento l1,Lancamento l2){
        
        if(Objects.equals(l1.getConta(),l2.getConta())){
            
           return l1.getData().compareTo(l2.getData());
        }else{
            return l1.getConta()-l2.getConta();
        }
        
        
    }
}
