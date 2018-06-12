
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;


public class Lista4Ex06 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        mudarPosicao(0,0);
        Direcao direcao = DIREITA;
        while (true){
            andar(direcao);
            if(ehFim(direcao)){
                if (!ehFim(ABAIXO)){
                    andarAbaixo();
                    direcao = mudarDirecao(direcao);
                } else {
                    break;
                }
            }
        }
    }
    
    private void andar (Direcao direcao){
        if(!ehFim(direcao)){
            if(direcao == DIREITA){
                andarDireita();
            } else {
                andarEsquerda();
            }
        }
    }
    
    private Direcao mudarDirecao(Direcao direcao){
        if(direcao == DIREITA){
            direcao = ESQUERDA;
        } else {
            direcao = DIREITA;
        }
        return direcao;
    }
    public static void main(String[] args) {
        MundoVisual.iniciar("Lista4Ex06.xml");
    }
}
