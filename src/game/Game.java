package game;

import board.Board;
import board.Campo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game{

    private boolean inGame = true;

    public Board board(){
        return new Board();
    }
    public static int[] jogada(Scanner scanner, char simboloAtual){
        int[] tentativa = new int[2];
        try {
            System.out.printf("%s %c%n", "Jogador: ", simboloAtual);
            System.out.print("Informe a linha: ");
            tentativa[0] = scanner.nextInt();
            System.out.print("Informe a coluna: ");
            tentativa[1] = scanner.nextInt();
            return tentativa;
        }
        catch (InputMismatchException e){
            System.out.println("posicao invalida!");
            scanner.nextLine();
            return null;
        }
    }
    public boolean verificarJogada(Campo[][] tabuleiro, int[] tentativa, char simboloAtual){
        try {
            if (tabuleiro[tentativa[0]][tentativa[1]].getSimbolo() == ' ') {
                tabuleiro[tentativa[0]][tentativa[1]].setSimbolo(simboloAtual);
                return true;
            } else {
                System.out.println("Posicao ja jogada!");
                return false;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Posicao inexistente!");
            return false;
            }
    }

    public boolean checaVitoria(Campo[][] tabuleiro, char simboloAtual) {

        for (int linha = 0; linha < 3; linha++) {
            if (tabuleiro[linha][0].getSimbolo() == simboloAtual &&
                    tabuleiro[linha][1].getSimbolo() == simboloAtual &&
                    tabuleiro[linha][2].getSimbolo() == simboloAtual) {
                return true;
            }
        }
        for (int coluna = 0; coluna < 3; coluna++) {
            if (tabuleiro[0][coluna].getSimbolo() == simboloAtual &&
                    tabuleiro[1][coluna].getSimbolo() == simboloAtual &&
                    tabuleiro[2][coluna].getSimbolo() == simboloAtual) {
                return true;
            }
        }
        if (tabuleiro[0][0].getSimbolo() == simboloAtual &&
                tabuleiro[1][1].getSimbolo() == simboloAtual &&
                tabuleiro[2][2].getSimbolo() == simboloAtual) {
            return true;
        }

        if (tabuleiro[0][2].getSimbolo() == simboloAtual &&
                tabuleiro[1][1].getSimbolo() == simboloAtual &&
                tabuleiro[2][0].getSimbolo() == simboloAtual) {
            return true;
        }else {
            return false;
        }
    }

    public boolean verificaEmpate(Campo[][] tabuleiro) {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna].getSimbolo() == ' ') {
                    return false;
                }
            }
        }
        return !checaVitoria(tabuleiro, 'X') && !checaVitoria(tabuleiro, 'O');
    }

    public Board reiniciarPartida(Scanner scanner) {
        System.out.println("Quer jogar novamente? (s/n)");
        try {
            char escolha = scanner.next().charAt(0);
            if (escolha == 'n' || escolha == 'N') {
                setInGame(false);
                return null;
            } else if (escolha == 's' || escolha == 'S'){
                return board();
            } else {
                System.out.println("Opcao invalida!");
                return null;
            }
        }
        catch (InputMismatchException e){
            System.out.println("Opcao invalida!");
            return null;
        }
    }


    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public boolean inGame() {
        return inGame;
    }


}
