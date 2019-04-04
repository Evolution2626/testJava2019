/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class Grimpeur extends Subsystem {

  public DoubleSolenoid avant;
  public DoubleSolenoid arriere;

  

  public enum Position {avant, arriere}

  public Grimpeur(){
    avant = new DoubleSolenoid(RobotMap.AVANT_FOWARD, RobotMap.AVANT_REVERSE);
    arriere = new DoubleSolenoid(RobotMap.ARRIERE_FOWARD, RobotMap.ARRIERE_REVERSE);

    

  }

  
  
  public void changerPosition(Value valeur, Position pos){

    if (valeur == Value.kForward) {
      
    }

    if (pos == Position.avant) {
      avant.set(valeur);
    }

    if (pos == Position.arriere) {
      arriere.set(valeur);
    }
    
  }

  public Value currentPosition(Position pos){
    if (pos == Position.avant) {
      return avant.get();
    }

    if (pos == Position.arriere) {
      return arriere.get();
    }
    return Value.kReverse;
  }

  public void setBothPosition(Value val){
    avant.set(val);
    arriere.set(val);
  }

  @Override
  public void initDefaultCommand() {
    
  }
}
