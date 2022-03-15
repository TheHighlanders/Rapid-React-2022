// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class intake extends SubsystemBase {
  /** Creates a new intake. */
  private CANSparkMax intake = new CANSparkMax(Constants.INTAKE,MotorType.kBrushless);
  public WPI_TalonSRX intakearm = new WPI_TalonSRX(Constants.INTAKEARM);

  public intake() {
    SupplyCurrentLimitConfiguration test = new SupplyCurrentLimitConfiguration();
    test.currentLimit = 20;
    test.enable = false;
    intakearm.configSupplyCurrentLimit(test);
  }

  public void ascend(){
    intake.set(1);
  }
  public void stop() {
    intake.set(0);
  }
  public void descend(){
    intake.set(-1);
  }

  public void intakeIn(){
    intakearm.set(-1);
  }
  
  public void outake(){
    intakearm.set(1);
  }

  public void stopintake(){
    intakearm.set(0);
  }

  public void autoIntake(){
    intakearm.set(0.2);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
