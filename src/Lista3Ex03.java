
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.ObjetoDoMundo;

public class Lista3Ex03 extends Furbot {

    /**
     * metodo para deslocar o objeto até a extremidade
     *
     */
    private int andarObjeto(Direcao extremidade) {
        //criar variável para contar os passos
        int passos = 0;
        //pegar o objeto . ObjetoDoMundo pode ser usado para pegar qualquer objeto no mundo
        ObjetoDoMundo objeto = getObjeto(AQUIMESMO);
        //enquanto não chegar na extremidade
        while (!objeto.ehFim(extremidade)) {
            //verificar a direcao e andar na direcao
            switch (extremidade) {
                case DIREITA:
                    objeto.andarDireita();
                    break;
                case ESQUERDA:
                    objeto.andarEsquerda();
                    break;
                case ACIMA:
                    objeto.andarAcima();
                    break;
            }
            //contar passo
            passos++;
        }
        return passos;
    }

    /**
     * metodo para verificar o tipo do objeto
     */
    private int verificarobjeto() {
        //variável feita para contar os passos dados pelo robo
        int passos = 0;

        if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
            passos = andarObjeto(ESQUERDA);
        } else {
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                passos = andarObjeto(DIREITA);

            } else {
                if (ehObjetoDoMundoTipo("Booleano", AQUIMESMO)) {
                    passos = andarObjeto(ACIMA);
                }
            }
        }
        //retornar os passos
        return passos;
    }

    @Override
    public void inteligencia() throws Exception {

        int passos = 0;

        while (true) {
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                while (!ehFim(ESQUERDA)) {
                    andarEsquerda();
                    passos++;
                }
            }
        }

    }

    private void andarAlien(char andarAlien) {
        //pegar alien
        if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
            while (!ehFim(ESQUERDA)) {
                andarEsquerda();
            }
        }
        //fazer ele andar para a esquerda

        
    }

    private void andar(char andar) {

    }

    private void mudarDirecao(char mudarDirecao) {

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex03.xml");
    }
}
