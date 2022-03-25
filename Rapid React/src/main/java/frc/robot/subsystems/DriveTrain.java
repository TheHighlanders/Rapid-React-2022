// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /** Creates a new driveTrain. */
  public CANSparkMax left1;
  //public WPI_VictorSPX left2;
  public CANSparkMax right1;
  //public WPI_VictorSPX right2;
  
  private double ramp = 1;

  public DriveTrain() {
    left1 = new CANSparkMax(Constants.LEFT_TWO, MotorType.kBrushless);
    //left2 = new WPI_VictorSPX(Constants.LEFT_TWO);
    right1 = new CANSparkMax(Constants.RIGHT_TWO, MotorType.kBrushless);
    //right2 = new WPI_VictorSPX(Constants.RIGHT_TWO);
    
    //left2.setInverted(false);
    left1.setInverted(false);
    
    left1.setOpenLoopRampRate(ramp);
    // left1.setClosedLoopRampRate(ramp);

    //left2.configOpenloopRamp(ramp,0);
    right1.setOpenLoopRampRate(ramp);
    //right2.configOpenloopRamp(ramp,0);

    //left1.setNeutralMode(NeutralMode.Brake);
    //left2.setNeutralMode(NeutralMode.Brake);
    //right1.setNeutralMode(NeutralMode.Brake);
    //right2.setNeutralMode(NeutralMode.Brake);

    //left2.follow(left1);
    //right2.follow(right1);
    
  }

  public void drivepower(double left_power, double right_power){
      left1.set(left_power);
      right1.set(right_power);

  }
  
  // public void drivespeed(double left_power, double right_power){
  //   left1.set(ControlMode.Velocity,left_power*2621.44);
  //   right1.set(ControlMode.Velocity,right_power*2621.44);
  // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
