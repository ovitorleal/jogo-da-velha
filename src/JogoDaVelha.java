import java.util.Scanner;

public class JogoDaVelha {

    // Criar o tabuleiro 3x3 (matriz)
    // Cada posição começa vazia (' ')
    static char[][] tabuleiro = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };


    //metodo do tabuleiro
  
    public static void mostrarTabuleiro() {

        System.out.println("\nTabuleiro:");

        // Percorre as linhas
        for (int i = 0; i < 3; i++) {

            // Imprime cada linha
            System.out.println(" " + tabuleiro[i][0] + " | " + tabuleiro[i][1] + " | " + tabuleiro[i][2]);

            // Imprime separador (menos na última linha)
            if (i < 2) {
                System.out.println("-----------");
            }
        }
    }

    
    // validar jogada
   
    public static boolean jogadaValida(int linha, int coluna) {

        // Verifica se está dentro dos limites da matriz (0 a 2)
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
            return false;
        }

        // Verifica se a posiçao esta ocupada
        if (tabuleiro[linha][coluna] != ' ') {
            return false;
        }

        // Se passou por tudo e valido
        return true;
    }

    
    // verificar vitoria
    
    public static boolean verificarVitoria(char jogador) {

        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {

            // Linha completa
            if (tabuleiro[i][0] == jogador &&
                    tabuleiro[i][1] == jogador &&
                    tabuleiro[i][2] == jogador) {
                return true;
            }

            // Coluna completa
            if (tabuleiro[0][i] == jogador &&
                    tabuleiro[1][i] == jogador &&
                    tabuleiro[2][i] == jogador) {
                return true;
            }
        }

        // Verifica diagonal principal
        if (tabuleiro[0][0] == jogador &&
                tabuleiro[1][1] == jogador &&
                tabuleiro[2][2] == jogador) {
            return true;
        }
        

        // Se não encontrou nenhuma condição nao vence
        return false;
    }

  
    // verifica empate

    public static boolean empate() {

        // Percorre toda a matriz
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                // Se encontrar espaço vazio, ainda não acabou
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }

        // matriz completa = empate
        return true;
    }

  
    // main
    
    public static void main(String[] args) {

        // Scanner para ler entradas do usuário
        Scanner leitor = new Scanner(System.in);

        // Jogador inicial (X começa)
        char jogador = 'X';

        // Loop principal do jogo (repete até vitória ou empate)
        while (true) {

            // Mostra o tabuleiro atual
            mostrarTabuleiro();

            // Pede a jogada
            System.out.println("\nJogador " + jogador + " - digite linha (0-2) e coluna (0-2):");

            int linha = leitor.nextInt();
            int coluna = leitor.nextInt();


            // VALIDAÇÃO DA JOGADA
            if (!jogadaValida(linha, coluna)) {
                System.out.println("Jogada inválida! Tente novamente.");
                continue; // volta pro início do loop
            }

            // REALIZA A JOGADA
            tabuleiro[linha][coluna] = jogador;


            // VERIFICA SE ALGUÉM GANHOU
            if (verificarVitoria(jogador)) {
                mostrarTabuleiro();
                System.out.println("\nJogador " + jogador + " venceu!");
                break; // encerra o jogo
            }

            
            // VERIFICA EMPATE
            if (empate()) {
                mostrarTabuleiro();
                System.out.println("\nEmpate!");
                break;
            }

        
            // TROCA DE JOGADOR
            if (jogador == 'X') {
                jogador = 'O';
            } else {
                jogador = 'X';
            }
        }

        // Fecha o scanner
        leitor.close();
    }
}
