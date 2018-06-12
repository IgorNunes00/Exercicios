
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Texto;

public class Lista3Ex13 extends Furbot {

    private String verificacao(String paises) {
        if (ehObjetoDoMundoTipo("Texto", AQUIMESMO)) {
            Texto texto = getObjeto(AQUIMESMO);
            switch (texto.getTexto()) {
                case "AUS":
                    paises += "AUSTRALIA ";
                    break;
                case "BRA":
                    paises += "BRASIL ";
                    break;
                case "FRA":
                    paises += "FRANCA ";
                    break;
                case "VEN":
                    paises += "VENEZUELA ";
                    break;

            }
        }
        andarDireita();
        return paises;
    }

    private String coletarNomePaises() {
        String paises = "";
        while (!ehFim(DIREITA)) {
            paises = verificacao(paises);
        }
        paises = verificacao(paises);
        return paises;
    }

    @Override
    public void inteligencia() throws Exception {

        mudarPosicao(0, getQtdeLinhas() - 1);

        String paises = coletarNomePaises();

        mudarPosicao(0, 0);

        int pos = 0;

        while (getY() != 4) {
            while (paises.charAt(pos) != ' ') {
                Texto letra = new Texto();
                letra.setValor(String.valueOf(paises.charAt(pos)));
                adicionarObjetoNoMundo(letra, AQUIMESMO);
                pos++;
                if (!ehFim(DIREITA)) {
                    andarDireita();
                }
            }
            andarAbaixo();
            mudarPosicao (0, getY());
            pos++;
            
        }
    }

    

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex13.xml");
    }

}

