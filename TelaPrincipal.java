import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TelaPrincipal extends JFrame implements KeyListener {
    private static final int tamTabuleiro = 10;
    private int posXAV = 0, posYAV = 0;
    private JPanel[][] quadrados;

    TelaPrincipal(){

         // Criando tabuleiro principal
        JPanel tabuleiro = new JPanel(new GridLayout(tamTabuleiro, tamTabuleiro));
        quadrados = new JPanel[tamTabuleiro][tamTabuleiro];

        //  Criando cada quadrado do tabuleiro
        for(int i = 0; i < tamTabuleiro; i++){
            for(int j = 0; j < tamTabuleiro; j++){
                Desenho quadrado = new Desenho(BlocoTipo.FUNDO);
                quadrado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                quadrados[i][j] = quadrado;
                tabuleiro.add(quadrado);
            }
        }

        add(tabuleiro, BorderLayout.CENTER);

        //  Configurações gerais
        this.addKeyListener(this);
        this.requestFocusInWindow();
        this.setFocusable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Trabalho 3 - POO");
        this.setSize(600, 600);
        this.setResizable(true);
        this.setVisible(true);

        attQuadradoSelecionado();
    }

    protected void attQuadradoSelecionado() {
        // Limpa o avatar do quadrado anterior
        for (int l = 0; l < tamTabuleiro; l++) {
            for (int c = 0; c < tamTabuleiro; c++) {
                ((Desenho) quadrados[l][c]).setSelecionado(false);
            }
        }
        // Marca o quadrado atual
        ((Desenho) quadrados[posXAV][posYAV]).setSelecionado(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int posXAntiga = posXAV;
        int posYAntiga = posYAV;

        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
            if(posXAV > 0){
                posXAV--;       // Anda pra cima
                attQuadradoSelecionado();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
            if(posXAV < tamTabuleiro - 1) {
                posXAV++;       // Anda pra baixo
                attQuadradoSelecionado();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            if(posYAV > 0){
                posYAV--;       // Anda pra esquerda
                attQuadradoSelecionado();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            if(posYAV < tamTabuleiro - 1){
                posYAV++;       // Anda pra direita
                attQuadradoSelecionado();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_1){
            if(posXAV < tamTabuleiro - 1){
                posXAV++;
            }else{
                posXAV = 0;
            }
            attQuadradoSelecionado();
            ((Desenho) quadrados[posXAntiga][posYAntiga]).setBlocoAtual(BlocoTipo.BLOCO1);
        }
        if(e.getKeyCode() == KeyEvent.VK_2){
            if(posXAV < tamTabuleiro - 1){
                posXAV++;
            }else{
                posXAV = 0;
            }
            attQuadradoSelecionado();
            ((Desenho) quadrados[posXAntiga][posYAntiga]).setBlocoAtual(BlocoTipo.BLOCO2);
        }
        if(e.getKeyCode() == KeyEvent.VK_3){
            if(posXAV < tamTabuleiro - 1){
                posXAV++;
            }else{
                posXAV = 0;
            }
            attQuadradoSelecionado();
            ((Desenho) quadrados[posXAntiga][posYAntiga]).setBlocoAtual(BlocoTipo.BLOCO3);
        }
        if(e.getKeyCode() == KeyEvent.VK_4){
            if(posXAV < tamTabuleiro - 1){
                posXAV++;
            }else{
                posXAV = 0;
            }
            attQuadradoSelecionado();
            ((Desenho) quadrados[posXAntiga][posYAntiga]).setBlocoAtual(BlocoTipo.BLOCO4);
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(posXAV < tamTabuleiro - 1){
                posXAV++;
            }else{
                posXAV = 0;
            }
            attQuadradoSelecionado();
            ((Desenho) quadrados[posXAntiga][posYAntiga]).setBlocoAtual(BlocoTipo.FUNDO);
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {}
    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    //  Gets e Sets
    public int getposXAV() {return posXAV;}
    public void setPosXAV(int posXAV) {this.posXAV = posXAV;}
    public int getPosYAV() {return posYAV;}
    public void setPosYAV(int posYAV) {this.posYAV = posYAV;}
    public JPanel[][] getQuadrados() {return quadrados;}
    public void setQuadrados(JPanel[][] quadrados) {this.quadrados = quadrados;}
}
