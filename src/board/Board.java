package board;



public class Board {

    private final Campo[][] tabuleiro;
    private char simboloAtual= 'X';

    public Board(){
        this.tabuleiro = new Campo[3][3];
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                this.tabuleiro[linha][coluna] = new Campo();
            }
        }
    }

    public static void limpaTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Erro ao limpar o console: " + e.getMessage());
        }
    }
    public void mostraTabuleiro(){
        limpaTela();
        System.out.println("    0   1   2");
        System.out.printf ("0   %c | %c | %c %n",tabuleiro[0][0].getSimbolo(),tabuleiro[0][1].getSimbolo(),tabuleiro[0][2].getSimbolo());
        System.out.println("   -------------");
        System.out.printf ("1   %c | %c | %c %n",tabuleiro[1][0].getSimbolo(),tabuleiro[1][1].getSimbolo(),tabuleiro[1][2].getSimbolo());
        System.out.println("   -------------");
        System.out.printf ("2   %c | %c | %c %n",tabuleiro[2][0].getSimbolo(),tabuleiro[2][1].getSimbolo(),tabuleiro[2][2].getSimbolo());
        System.out.println(" ");
    }

    public Campo[][] getTabuleiro() {
        return tabuleiro;
    }



    public char getSimboloAtual() {
        return simboloAtual;
    }

    public void setSimboloAtual(char simboloAtual) {
        this.simboloAtual = simboloAtual;
    }
}