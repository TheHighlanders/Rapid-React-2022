// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class intake extends SubsystemBase {
  /** Creates a new intake. */
  private CANSparkMax intake = new CANSparkMax(Constants.INTAKE,MotorType.kBrushless);

  public intake() {}

  public void ascend(){
    intake.set(1);
  }
  public void stop() {
    intake.set(0);
  }
  public void descend(){
    intake.set(-1);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
