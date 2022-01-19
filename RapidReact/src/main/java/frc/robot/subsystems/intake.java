// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class intake extends SubsystemBase {
  /** Creates a new cargoMech. */
  private WPI_VictorSPX intakemotor = new WPI_VictorSPX(Constants.MOTORONE);

  
  public intake() {}
  
  public void IntakeIn(){
    intakemotor.set(1);
  }
  
  public void IntakeOut(){
    intakemotor.set(-1);//oposite direction 
  }
  
  public void Stop(){
      intakemotor.set(0);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
