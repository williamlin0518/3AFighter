package view;

import javafx.scene.image.Image;

public class ChooseBackground   {

    int number;
    public  Image image;
    public ChooseBackground(int number){
        this.number=number;
    }

    public Image choose(){
        switch(number){
            case 1: image=new Image("stage.gif", 1400, 700, false, true);
                break;
            case 2: image=new Image("stage2.gif", 1400, 700, false, true);
                break;
            case 3: image=new Image("stage3.gif", 1400, 700, false, true);
                break;
            case 4: image=new Image("stage4.gif", 1400, 700, false, true);
                break;
            case 5: image=new Image("stage5.gif", 1400, 700, false, true);
                break;
            case 6: image=new Image("stage6.gif", 1400, 700, false, true);
                break;
            case 7: image=new Image("stage7.gif", 1400, 700, false, true);
                break;
            case 8: image=new Image("stage8.gif", 1400, 700, false, true);
                break;
            case 9: image=new Image("stage9.gif", 1400, 700, false, true);
                break;
            case 10: image=new Image("stage10.gif", 1400, 700, false, true);
                break;

        }

        return image;
    }

}
