package sample;



import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class PlayerFat extends Pane {

    boolean up,down,right,left,direction;
    ImageView imageView;
    public static int playerWidth;
    public static int playerHeight;
    int PLAYER_X = 0;
    int PLAYER_Y = 0;
    int stopLeft;
    int stopRight;
    int walkLeft;
    int walkRight;
    int punchLeft;
    int punchRight;

    int kickLeft;
    int kickRight;
    int jumpLeft;
    int jumpRight;
    int beAttackedLeft;
    int beAttackedRight;

    int DELAY=500;
    Rectangle2D rectangle2D;
    SpriteAnimation animation;
    public PlayerFat(ImageView imageView,int playerWidth,int playerHeight, int stopLeft,int stopRight,int walkLeft,
                     int walkRight,int punchLeft,int punchRight,int kickLeft,int kickRight,int jumpLeft,int jumpRight,int beAttackedLeft,int beAttackedRight ){

        this.imageView=imageView;
        this.stopLeft=stopLeft;
        this.stopRight=stopRight;
        this.walkLeft=walkLeft;
        this.walkRight=walkRight;
        this.punchLeft=punchLeft;
        this.punchRight=punchRight;
        this.kickLeft=kickLeft;
        this.kickRight=kickRight;
        this.jumpLeft=jumpLeft;
        this.jumpRight=jumpRight;
        this.beAttackedLeft=beAttackedLeft;
        this.beAttackedRight=beAttackedRight;

        rectangle2D=new Rectangle2D(PLAYER_X,PLAYER_Y , playerWidth, playerHeight);
        imageView.setViewport(rectangle2D);
        animation =new SpriteAnimation(imageView, Duration.millis(DELAY), 4,4, PLAYER_X, PLAYER_Y, playerWidth, playerHeight);
        getChildren().addAll(imageView);

    }
    public void moveX(int moveX){
        for (int i = 0; i < Math.abs(moveX); i++) {
            if (right) {
                this.setTranslateX(this.getTranslateX() + 1);
            }
            if (left) {
                this.setTranslateX(this.getTranslateX() - 1);
            }
        }
    }
    public void update( boolean right, boolean left,boolean punch,boolean kick,boolean beAttacked,boolean direction,boolean up){


        this.right=right;
        this.left=left;
        this.direction=direction;



        if(right){
            this.animation.play();
            this.animation.setOffsetY(walkRight);
            this.animation.setOffsetX(0);
            if(this.getTranslateX()<=1200) {
                this.moveX(8);

            }
        }
        else if(left){
            this.animation.play();
            this.animation.setOffsetY(walkLeft);
            this.animation.setOffsetX(0);

            if(this.getTranslateX()>=15) {
                this.moveX(8);
            }
        }
        else if(punch){
            if(direction) {

                this.animation.play();
                this.animation.setOffsetY(punchRight);
                this.animation.setOffsetX(0);
                this.moveX(1);
                System.out.println("low");
            }
            if(!direction){

                this.animation.play();
                this.animation.setOffsetY(punchLeft);
                this.animation.setOffsetX(0);
                this.moveX(-1);

            }
        }
        else if(up){
            if(direction) {

                this.animation.play();
                this.animation.setOffsetY(jumpRight);
                this.animation.setOffsetX(0);

                System.out.println("low");
            }
            if(!direction){
                this.animation.play();
                this.animation.setOffsetY(jumpLeft);
                this.animation.setOffsetX(0);
            }
        }
        else if(kick){
            if(direction) {
                this.animation.play();
                this.animation.setOffsetY(kickRight);
                this.animation.setOffsetX(0);
                this.moveX(1);
            }
            if(!direction){
                this.animation.play();
                this.animation.setOffsetY(kickLeft);
                this.animation.setOffsetX(0);
                this.moveX(-1);
            }
        }
        else if(beAttacked) {
            if(direction) {
                this.animation.play();
                this.animation.setOffsetY(beAttackedRight);
                this.animation.setOffsetX(0);
            }
            if(!direction) {
                this.animation.play();
                this.animation.setOffsetY(beAttackedLeft);
                this.animation.setOffsetX(0);
            }

        }

        else {
            if(direction) {
                this.animation.play();
                this.animation.setOffsetY(stopRight);
                this.animation.setOffsetX(0);
            }else{
                this.animation.play();
                this.animation.setOffsetY(stopLeft);
                this.animation.setOffsetX(0);
            }
        }
    }

}