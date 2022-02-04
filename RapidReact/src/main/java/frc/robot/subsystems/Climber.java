// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  public WPI_TalonFX BabyMotor = new WPI_TalonFX(Constants.CLIMBERMOTOR_ONE); 
  public WPI_TalonFX DadMotor = new WPI_TalonFX(Constants.CLIMBERMOTOR_TWO); 

  public Climber() { }


  public void SetBabyMotorPower(double BabyMotorPower){
    BabyMotor.set(BabyMotorPower);
  }
  
  public void SetDadMotorPower(double DadMotorPower){
    BabyMotor.set(DadMotorPower);
  }

  public void BabyStopMotor(){
    BabyMotor.set(0);
  }

  public void DadStopMotor(){
    DadMotor.set(0);
  }





  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
