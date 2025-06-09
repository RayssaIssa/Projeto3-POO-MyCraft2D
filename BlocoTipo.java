import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public enum BlocoTipo {
    FUNDO("fundo.png"),    //bloco vazio
    AVATAR("avatar.png"),  //avatar
    BLOCO1("bloco1.png"),  //grama
    BLOCO2("bloco2.png"),  //terra
    BLOCO3("bloco3.png"),  //tijolo
    BLOCO4("bloco4.png");  //flores

    private final Image img;

    BlocoTipo(String nomeArquivo){
        Image imgCarregada = null;
        try {
            URL imgUrl = BlocoTipo.class.getResource("/images/" + nomeArquivo);
            if (imgUrl == null) {
                System.err.println("Erro: Imagem " + nomeArquivo + " não encontrada em /images/");
                imgCarregada = criarImagemDeErro();
            } else {
                imgCarregada = ImageIO.read(imgUrl);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar a imagem " + nomeArquivo + ": " + e.getMessage());
            imgCarregada = criarImagemDeErro();
        }
        this.img = imgCarregada;
    }

    // Método para criar uma imagem de erro (se uma imagem não puder ser carregada)
    public Image criarImagemDeErro(){
        // Cria uma imagem simples de 50x50 com um círculo azul
        BufferedImage img = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(new Color(0, 0, 255, 150));
        g2d.fillOval(5, 5, 40, 40);
        g2d.dispose();
        return img;
    }

    public Image getImg() {
        return img;
    }
}
