
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

public class Lista3Ex07 extends Furbot {

    private void andar(Direcao direcao) {
        if (direcao == DIREITA) {
            andarDireita();
        } else {
            andarEsquerda();
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

    @Override
    public void inteligencia() throws Exception {
        Direcao direcao = DIREITA;
        while (true) {
            andar(direcao);
            verificarNumero();
            if (ehFim(direcao)) {
                diga("Resultado =  " + resultado);
                resultado = 0;
                if (!ehFim(ABAIXO)) {
                    andarAbaixo();
                    verificarNumero();
                    direcao = mudarDirecao(direcao);
                } else {
                    break;
                }
            }
        }

    }
    /*atributo que armazena resultado das operações
     */

    private int resultado = 0;

    private void verificarNumero() {
        if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
            Numero num = getObjeto(AQUIMESMO);
            switch (num.getValor()) {
                case 1:
                    resultado += 10;
                    break;
                case 2:
                    resultado -= 2;
                    break;
                case 3:
                    resultado *= 2;
                    break;
                case 4:
                    if (resultado % 2 == 0) {
                        resultado -= 5;
                    } else {
                        resultado += 2;
                    }
                    break;
            }

        }
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex07.xml");
    }
}
