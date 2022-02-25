// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  public WPI_TalonFX BabyMotor = new WPI_TalonFX(Constants.CLIMBERMOTOR_ONE); 
  public WPI_TalonFX DadMotor = new WPI_TalonFX(Constants.CLIMBERMOTOR_TWO); 

  public Climber() {
    // BIG ARMS: up is negative and down is positive 
    BabyMotor.getSelectedSensorPosition();
    DadMotor.configFactoryDefault(); // clears any non default settings
    DadMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 1000);
    DadMotor.configPeakOutputForward(1); // Configures the forward peak output percentage.
    BabyMotor.configFactoryDefault(); 
    BabyMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 1000);
    BabyMotor.configPeakOutputForward(1);

    // math
    DadMotor.config_kP(0,50);
    DadMotor.config_kI(0, 0.2);
    DadMotor.config_kD(0,10);

    BabyMotor.config_kP(0,20);
    BabyMotor.config_kD(0,100);
   }


  public void SetBabyMotorPower(){
    //if limit switch was not pressed
    // boolean switchIsGood = limitSwitch.get() == true;
    // DriverStation.reportWarning("Sensor Status: " + switchIsGood, false);
    // if(limitSwitch.get() == false){
    //   //move left not right 
    //   DriverStation.reportWarning("Hook left up", false);
    //   m_Hook.HookUpLeft();
    // }
    //  //if limit switch was pressed
    // if(limitSwitch.get() == true){
    //   m_Hook.HookStopLeft();
    // }
    BabyMotor.set(ControlMode.Position,2000); 
  }
  
  public void SetDadMotorPower(){
    DadMotor.set(ControlMode.Position, -425);
  }

  public void BabyStopMotor(){
    BabyMotor.set(0);
    //BabyMotor.set(ControlMode.Position, 0);
  }

  public void DadStopMotor(){
    DadMotor.set(0);
    //DadMotor.set(ControlMode.Position, 0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
