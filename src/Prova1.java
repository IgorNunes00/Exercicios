
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

public class Prova1 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        //criar as variáveis para os cálculos
        int aliensPares = 0; //contar aliens das linhas pares
        float aliensTotal = 0; //contar total de aliens
        int qtdMultiplos5 = 0; //contar números múltiplos de 5
        int somaNumeros = 0; //somar os números
        float qtdNumeros = 0; //contar a quantidade de números 

        //definir a direção
        Direcao direcao = ABAIXO;
        //laço para o robô caminhar
        while (true) {

            //se tem alien
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                //contar o alien
                aliensTotal++;
                //verificar se o alien está em linha par para contar
                if (getY() % 2 == 0) {
                    aliensPares++;
                }
            } else {
                //se tem numero
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    //pegar o numero
                    Numero numero = getObjeto(AQUIMESMO);
                    //testar se é múltiplo de 5 para contar
                    if (numero.getValor() % 5 == 0) {
                        qtdMultiplos5++;
                    }
                    //testar se o número está na linha e coluna ímpar
                    if (getY() % 2 != 0 && getX() % 2 != 0) {
                        //somar o número
                        somaNumeros += numero.getValor();
                        //contar o número
                        qtdNumeros++;
                    }
                }
            }

            //testar se não tem parede para onde o robô vai
            if (!ehObjetoDoMundoTipo("Parede", direcao)) {
                //robô caminha na direção
                if (direcao == ABAIXO) {
                    andarAbaixo();
                } else {
                    andarAcima();
                }
            } else {
                //dar um passo para a direita por causa da parede
                andarDireita();
            }
            //testar se chegou no fim da direção para onde o robô vai
            if (ehFim(direcao)) {

                //se tem alien
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    //contar o alien
                    aliensTotal++;
                    //verificar se o alien está em linha par para contar
                    if (getY() % 2 == 0) {
                        aliensPares++;
                    }
                } else {
                    //se tem numero
                    if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                        //pegar o numero
                        Numero numero = getObjeto(AQUIMESMO);
                        //testar se é múltiplo de 5 para contar
                        if (numero.getValor() % 5 == 0) {
                            qtdMultiplos5++;
                        }
                        //testar se o número está na linha e coluna ímpar
                        if (getY() % 2 != 0 && getX() % 2 != 0) {
                            //somar o número
                            somaNumeros += numero.getValor();
                            //contar o número
                            qtdNumeros++;
                        }
                    }
                }

                //testar se não é o fim do mapa
                if (!ehFim(DIREITA)) {
                    andarDireita();
                    //muda a direção
                    if (direcao == ABAIXO) {
                        direcao = ACIMA;
                    } else {
                        direcao = ABAIXO;
                    }
                } else {
                    //chegou no fim do mapa
                    break;
                }
            }
        }
        //sem tem aliens
        if (aliensTotal > 0) {
            diga("% de aliens nas linhas pares " + aliensPares * 100 / aliensTotal);
        }
        diga("Quantidade de múltiplos de 5 = " + qtdMultiplos5);
        //se tem números
        if (qtdNumeros > 0) {
            diga("Média dos números nas linhas e colunas ímpares = "
                    + somaNumeros / qtdNumeros);
        }
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Prova1.xml");
    }

}
