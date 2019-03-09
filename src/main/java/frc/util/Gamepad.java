package frc.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Gamepad extends Joystick{

    public Gamepad(int port){ // Construit un objet Gamepad
        super(port); // Construit un objet joystick à l'intérieur
    }


    //Buttons
    public JoystickButton getBtn(int number){
        return new JoystickButton(this, number);
    }

    //DPad
    public boolean getRawDpadUp(){ return getPOV() == 0; }
    public boolean getRawDpadDown(){ return getPOV() == 180; }
    public boolean getRawDpadLeft(){ return getPOV() == 270; }
    public boolean getRawDpadRight(){ return getPOV() == 90; }

    public DPadButton getDpadUp(){ return new DPadButton(this, DPadButton.Direction.UP); }
    public DPadButton getDpadDown(){ return new DPadButton(this, DPadButton.Direction.DOWN); }
    public DPadButton getDpadLeft(){ return new DPadButton(this, DPadButton.Direction.LEFT); }
    public DPadButton getDpadRight(){ return new DPadButton(this, DPadButton.Direction.RIGHT); }



    /**
     * Cette classe permet d'ajouter les boutons DPad en tant qu'objet Button
     * Inspiré de la classe de l'équie 694 https://github.com/Team694/Alfred/blob/master/src/main/java/frc/util/Gamepad.java#L500
     */
    public static class DPadButton extends Button{
        public static enum Direction { UP, DOWN, LEFT, RIGHT }

        private Gamepad gamepad;
        private Direction direction;

        public DPadButton(Gamepad gamepad, Direction direction){
            this.gamepad = gamepad;
            this.direction = direction;
        }

        @Override
        public boolean get(){
            switch (direction) {
                case UP:
                    return gamepad.getRawDpadUp();
                case DOWN:
                    return gamepad.getRawDpadDown();
                case LEFT:
                    return gamepad.getRawDpadLeft();
                case RIGHT:
                    return gamepad.getRawDpadRight();
                default:
                    return false;
            }
        }

    }
}