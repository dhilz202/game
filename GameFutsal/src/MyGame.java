
import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.object.AnimatedSprite;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.background.ImageBackground;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;


public class MyGame extends Game {
    Background background;
    Sprite gawang_kiri,gawang_kanan;
    AnimatedSprite player;
  
    @Override
    public void initResources() {
        
        background = new ImageBackground(getImage("Resources/background.jpg"),800,600);
        gawang_kiri = new Sprite(getImage("Resources/gawang_kiri.png"),0,235);
        gawang_kanan = new Sprite(getImage("Resources/gawang_kanan.png"),755,235);
        
        BufferedImage []images_player = getImages("Resources/Player.png",2,1);
        player = new AnimatedSprite(images_player,500,400);
        
       
    }

    @Override
    public void update(long l) {
        if(keyDown(KeyEvent.VK_LEFT)){
            player.setAnimationFrame(0,0);
            player.setSpeed(-1,0);
            player.update(1);
        }
        if(keyDown(KeyEvent.VK_RIGHT)){
            player.setAnimationFrame(0,0);
            player.setSpeed(1,0);
            player.update(1);
        }
        if(keyDown(KeyEvent.VK_UP)){
            player.setAnimationFrame(0,0);
            player.setSpeed(0,-1);
            player.update(1);
        }
        if(keyDown(KeyEvent.VK_DOWN)){
            player.setAnimationFrame(0,0);
            player.setSpeed(0,1);
            player.update(1);
        }
            
    }

    @Override
    public void render(Graphics2D gd) {
        background.render(gd);
        gawang_kiri.render(gd);
        gawang_kanan.render(gd);
        player.render(gd);
  
    }
    
    public static void main(String[] args){
        GameLoader game = new GameLoader();
        game.setup(new MyGame(),new Dimension(800,600),false);
        game.start();
               
    }
}
