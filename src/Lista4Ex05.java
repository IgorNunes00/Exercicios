
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

public class Lista4Ex05 extends Furbot {

    private boolean ehPrimo(int num) {
        for (int divi = 2; divi <= num / 2; divi++) {
            if (num % divi == 0) {
                return false;
            }
        }
        return true;
    }

    private String primos(int numero) {
        String textoPrimo = "Primos abaixo do " + numero + "\n";
        for (int cont = 1; cont < numero; cont++) {
            if (ehPrimo(cont)) {
                textoPrimo += cont + " ";
            }
        }
        return textoPrimo;
    }

    @Override
    public void inteligencia() throws Exception {
        while (!ehFim(ESQUERDA)) {
            andarEsquerda();
        }
        while (!ehFim(ACIMA)) {
            andarAcima();
        }
        Direcao direcao = DIREITA;
        while (true) {
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                System.out.println(primos(numero.getValor()));
            }
            andar(direcao);
            if (ehFim(direcao)) {
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    Numero numero = getObjeto(AQUIMESMO);
                    System.out.println(primos(numero.getValor()));
                }
                if (!ehFim(ABAIXO)) {
                    andarAbaixo();
                    direcao = mudarDirecao(direcao);
                } else {
                    break;
                }
            }
        }

    }

    private void andar(Direcao direcao) {
        if (!ehFim(direcao)) {
            if (direcao == DIREITA) {
                andarDireita();
            } else {
                andarEsquerda();
            }
        }
    }

    private Direcao mudarDirecao(Direcao direcao) {
        if (direcao == DIREITA) {
            direcao = ESQUERDA;
        } else {
            direcao = DIREITA;
        }
        return direcao;
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista4Ex05.xml");
    }
}
