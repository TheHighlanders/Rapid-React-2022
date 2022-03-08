// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Door extends SubsystemBase {
  public WPI_TalonSRX Door = new WPI_TalonSRX(Constants.DOORMOTOR);
 
  public Door() {
   // Door.setInverted(true);
    Door.configFactoryDefault(); // clears any non default settings
    Door.configOpenloopRamp(0.2, 0); // min time to go from neutral to full throttle
    // The feedback Device is a Quad Encoder (quare period of out phase)
    // 0 means it's Primary closed loop (1 is auxiliary)
    // 1000 is the timeout value
    Door.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 1000);
    Door.configPeakOutputForward(1); // Configures the forward peak output percentage.
    Door.config_kP(0,20); //Constants is 0 and P value is 20
    Door.config_kD(0,100);
    Door.setSelectedSensorPosition(0); // sets the sensor position to 0 
    // ((Math.PI * 6)/360.0); btw 6 is the wheel diameter 
  }

  public void openDoor(){
    //DriverStation.reportWarning("Up--------------(._.)------------------", false);
    Door.set(ControlMode.Position,189);
  }

  public void closeDoor(){
    //DriverStation.reportWarning("down--------------(._.)----------------", false);
    Door.set(ControlMode.Position,0); // moves back to down 0
  }

  public void centerDoor(){
    Door.set(0.1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

