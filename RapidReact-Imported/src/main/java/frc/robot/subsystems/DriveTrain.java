// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

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
  final double magic = 2863.727518701257;
  public final double pulses_per_revolution = 10.72;
  

  public DriveTrain() {
    left1 = new CANSparkMax(Constants.LEFT_TWO, MotorType.kBrushless);
    //left2 = new WPI_VictorSPX(Constants.LEFT_TWO);
    right1 = new CANSparkMax(Constants.RIGHT_TWO, MotorType.kBrushless);
    //right2 = new WPI_VictorSPX(Constants.RIGHT_TWO);
    
    //left2.setInverted(false);
    left1.setInverted(false);
    
    left1.setOpenLoopRampRate(ramp);

    // left2.configOpenloopRamp(ramp,0);
    right1.setOpenLoopRampRate(ramp);

    left1.setClosedLoopRampRate(ramp*0.5);
    right1.setClosedLoopRampRate(ramp*0.5);
    left1.getPIDController().setP(1/magic,0);
    right1.getPIDController().setP(1/magic,0);
    left1.getPIDController().setD(5/magic,0);
    right1.getPIDController().setD(5/magic,0);

    left1.getPIDController().setP(0.25,1);
    right1.getPIDController().setP(0.25,1);
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
  
  public void drivespeed(double left_power, double right_power){
    left1.getPIDController().setReference(left_power*magic,com.revrobotics.CANSparkMax.ControlType.kVelocity,0);//set(ControlMode.Velocity,left_power*2621.44);
    right1.getPIDController().setReference(right_power*magic,com.revrobotics.CANSparkMax.ControlType.kVelocity,0);//set(ControlMode.Velocity,left_power*2621.44);
  }
  public void driveposition(double left_power, double right_power){
    left1.getPIDController().setReference(left_power,com.revrobotics.CANSparkMax.ControlType.kPosition,1);//set(ControlMode.Velocity,left_power*2621.44);
    right1.getPIDController().setReference(right_power,com.revrobotics.CANSparkMax.ControlType.kPosition,1);//set(ControlMode.Velocity,left_power*2621.44);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
