// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class cargoMech extends SubsystemBase {
  /** Creates a new cargoMech. */
  private WPI_VictorSPX motorone = new WPI_VictorSPX(Constants.MOTORONE);
  private WPI_VictorSPX motortwo = new WPI_VictorSPX(Constants.MOTORTWO);
  private WPI_VictorSPX motorthree = new WPI_VictorSPX(Constants.MOTORTHREE);
  private WPI_VictorSPX motorfour = new WPI_VictorSPX(Constants.MOTORFOUR);
  public cargoMech() {}
  public void IntakeIn(){
  motorone.set(1);
  }
  public void IntakeOut(){
    motorone.set(-1);//oposite direction 
    }
    public void Stop(){
      motorone.set(0);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
