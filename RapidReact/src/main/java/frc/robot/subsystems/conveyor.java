// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class conveyor extends SubsystemBase {
  /** Creates a new conveyor. */
  private WPI_VictorSPX conveyor1 = new WPI_VictorSPX(Constants.CONVEYORMOTOR_ONE);
  private WPI_VictorSPX conveyor2 = new WPI_VictorSPX(Constants.CONVEYORMOTOR_TWO);

  public conveyor() {}

  public void ascendleft(){
    conveyor1.set(1);
  }
  public void ascendright() {
    conveyor2.set(1);
  }
  public void stopleft() {
    conveyor1.set(0);
  }
  public void stopright(){
    conveyor2.set(0);
  }
  public void descendleft(){
    conveyor1.set(1);
  }
  public void descendright(){
    conveyor2.set(1);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
