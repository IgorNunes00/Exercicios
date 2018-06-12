
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

public class Lista3Ex12 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        while (!ehFim(ESQUERDA)) {
            andarEsquerda();
        }
        while (!ehFim(ACIMA)) {
            andarAcima();
        }
        
        top();
        
        andarAbaixo();
        andarEsquerda();
        andarEsquerda();
        
        top();
        
        andarAbaixo();
        andarEsquerda();
        andarEsquerda();
        
        top();
        
        andarEsquerda();
        }
    
    private void top (){
        
        Numero n1 = getObjeto(AQUIMESMO);
        int n1tnc = n1.getValor();
        
        andarDireita();
        
        Numero n2 = getObjeto(AQUIMESMO);
        int n2tnc = n2.getValor();
        
        andarDireita();
        
        int resultado = n1tnc - n2tnc;
        
        Numero zoboli = new Numero();
        zoboli.setValor(resultado);
        adicionarObjetoNoMundo(zoboli, AQUIMESMO);
         
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex12.xml");
    }
}
