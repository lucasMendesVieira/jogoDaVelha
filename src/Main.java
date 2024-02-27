import board.Board;
import game.Game;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Imports
        Game game = new Game();
        Board board = game.board();
        Scanner scanner = new Scanner(System.in);

        while(game.inGame()){
            board.mostraTabuleiro();
                int [] jogada = Game.jogada(scanner, board.getSimboloAtual());
                if(jogada != null && game.verificarJogada(board.getTabuleiro(),jogada,board.getSimboloAtual())){
                        if(game.checaVitoria(board.getTabuleiro(), board.getSimboloAtual())){
                            board.mostraTabuleiro();
                            System.out.printf("Jogador %c venceu!\n",board.getSimboloAtual());
                            board = game.reiniciarPartida(scanner);

                        }else if(game.verificaEmpate(board.getTabuleiro())){
                            board.mostraTabuleiro();
                            System.out.println(" ");
                            System.out.println("Deu velha!\n");
                            board = game.reiniciarPartida(scanner);
                        }
                        else if (board.getSimboloAtual()=='X')
                        {
                            board.setSimboloAtual('O');
                        } else{
                            board.setSimboloAtual('X');
                        }
                }
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.getMessage();
            }
            }
        }
    }
