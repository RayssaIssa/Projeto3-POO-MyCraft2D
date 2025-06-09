import javax.swing.*;
import java.awt.*;

public class Desenho extends JPanel {
    private boolean selecionado;
    private BlocoTipo blocoAtual;

    Desenho(BlocoTipo bloco){
        this.blocoAtual = bloco;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha a imagem para preencher o quadrado
        if (blocoAtual.getImg() != null) {
            g.drawImage(blocoAtual.getImg(), 0, 0, getWidth(), getHeight(), this);
        }

        // Se este quadrado estiver selecionado, desenha o avatar
        if (selecionado) {
            Image avatar = BlocoTipo.AVATAR.getImg();
            g.drawImage(avatar, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void setBlocoAtual(BlocoTipo novo) {
        this.blocoAtual = novo;
        repaint();
    }
    public boolean isSelecionado() {
        return selecionado;
    }
    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
        repaint();
    }
}
