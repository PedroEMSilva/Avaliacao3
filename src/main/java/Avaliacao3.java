
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.avaliacao.Lancamento;
import utfpr.ct.dainf.if62c.avaliacao.LancamentoComparator;
import utfpr.ct.dainf.if62c.avaliacao.ProcessaLancamentos;

/**
 * IF62C Fundamentos de Programação 2 Avaliação parcial.
 *
 * @author
 */
public class Avaliacao3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        String nome1;
        System.out.println("Digite o caminho:  ");
        nome1 = scanner.next();
        ProcessaLancamentos p = new ProcessaLancamentos(nome1);
        List<Lancamento> l1 = p.getLancamentos();
        l1.sort(new LancamentoComparator());
        System.out.print("Digite o numero da conta: ");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, informe um valor numérico!");
                scanner.next();
            }
            num = scanner.nextInt();
        }
        int flag = 0;
        for (Lancamento l : l1) {
            if (Objects.equals(l.getConta(), num)) {
                flag = 1;
            }
        }

        while (num != 0) {
            if (flag == 1) {
                exibeLancamentosConta(l1, num);
            } else {
                System.out.println("Conta inexistente");
            }
            System.out.print("Digite o numero da conta: ");
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
            } else {
                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, informe um valor numérico!");
                    scanner.next();
                }
                num = scanner.nextInt();
            }
            flag = 0;
            for (Lancamento l : l1) {
                if (Objects.equals(l.getConta(), num)) {
                    flag = 1;
                }

            }

        }
    }

    public static void exibeLancamentosConta(List<Lancamento> lancamentos, Integer conta) {

        for (Lancamento l : lancamentos) {
            if (Objects.equals(l.getConta(), conta)) {
                System.out.println(l);
            }
        }
    }

}
