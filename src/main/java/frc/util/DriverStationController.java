package frc.util;

import edu.wpi.first.wpilibj.buttons.Button;

public class DriverStationController extends Gamepad{

    public DriverStationController(int port){
        super(port);
    }

    /**
     * Permet d'obtenir les valeurs de différentes directions du joystick de la driver station en tant que bouton 
     * @param direction direction du joystick voulue
     * @return
     */
    public DSJoystickButton getJoystickButton(DSJoystickButton.Direction direction){ return new DSJoystickButton(this, direction); }


    public static class DSJoystickButton extends Button{

        private DriverStationController controller;
        private Direction direction;

        public static enum Direction { UP, DOWN, LEFT, RIGHT }
        public DSJoystickButton(DriverStationController controller, Direction direction){
            this.controller = controller;
            this.direction = direction;
        }


        @Override
        public boolean get(){
            switch (direction) {
                case UP:
                    return (controller.getRawAxis(1) > 0);
                case DOWN:
                    return (controller.getRawAxis(1) < 0);
                case LEFT:
                    return (controller.getRawAxis(0) < 0);
                case RIGHT:
                    return (controller.getRawAxis(0) > 0);
                default:
                    return false;
            }
        }


    }
    
}