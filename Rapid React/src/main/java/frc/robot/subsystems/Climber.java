// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  public WPI_TalonSRX BabyMotor = new WPI_TalonSRX(Constants.CLIMBERMOTOR_TWO); // up is negative and down is positive
  public WPI_TalonSRX DadMotor = new WPI_TalonSRX(Constants.CLIMBERMOTOR_ONE); 
  public WPI_VictorSPX DadMotor1 = new WPI_VictorSPX(Constants.CLIMBERMOTOR_THREE);

  public Climber() {
    

    DadMotor.configFactoryDefault(); // clears any non default settings
    DadMotor.configOpenloopRamp(0.5, 0);
    DadMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 1000);
    
    DadMotor.configPeakOutputForward(1); // Configures the forward peak output percentage.
    DadMotor.configPeakOutputReverse(-1); // Configures the forward peak output percentage.
    DadMotor.setSelectedSensorPosition(0);
    DadMotor.setInverted(false);
    DadMotor.setSensorPhase(true);
   
    // DadMotor.setSelectedSensorPosition(0);
    // math
    DadMotor.config_kP(0,50);
    DadMotor.config_kI(0,0);
    DadMotor.config_kD(0,10);
    SupplyCurrentLimitConfiguration test = new SupplyCurrentLimitConfiguration();
    test.currentLimit = 100;
    test.enable = false;
    DadMotor.configSupplyCurrentLimit(test);

    BabyMotor.configFactoryDefault(); 
    BabyMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 1000);
    BabyMotor.setSensorPhase(true);
    BabyMotor.configPeakOutputForward(1);
    BabyMotor.configPeakOutputReverse(-1);

    BabyMotor.config_kP(0,10);
    BabyMotor.config_kI(0, 0);
    BabyMotor.config_kD(0,20);
    
    
    // BabyMotor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
    DadMotor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
    DadMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);

    DadMotor1.follow(DadMotor);
    DadMotor1.setInverted(true);
  }

 
  public void SetBabyMotorUp(){
    BabyMotor.set(-1.0);
    //BabyMotor.set(ControlMode.Position,-2000); 
  }
  
  public void SetDadMotorUp(){
    DadMotor.set(-0.9);
    //DadMotor.set(ControlMode.Position, -1920);
  }

  public void SetBabyMotorDown(){
    BabyMotor.set(1);
    //BabyMotor.set(ControlMode.Position, 0);
  }

  public void SetDadMotorDown(){
    DadMotor.set(0.9);
    // DadMotor.set(ControlMode.Position, 0);
  }
  public void SetDadMotorHold(){
    DadMotor.setSelectedSensorPosition(0);
    DadMotor.set(ControlMode.Velocity,0);
  }

  public void SetBabyMotorHold(){
    BabyMotor.setSelectedSensorPosition(0);
    BabyMotor.set(ControlMode.Position,0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
