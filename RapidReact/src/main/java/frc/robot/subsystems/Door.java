// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Door extends SubsystemBase {
  /** Creates a new Door. */
  
  private WPI_TalonSRX Door = new WPI_TalonSRX(Constants.DOORMOTOR);

  public Door() {
    Door.setNeutralMode(NeutralMode.Coast);
    Door.setInverted(false);
    Door.setSensorPhase(false);

  }

  public void drivePower(double power){
    Door.set(power);
    DriverStation.reportWarning("Door pow =" + power, false);
  }

  public void open(){
    Door.set(ControlMode.Position, -409600/Constants.INCHES_PER_ROTATION);
    DriverStation.reportWarning("Up--------------(._.)------------------", false);
    if (Door.getSelectedSensorPosition()<5){
Door.set(0.2);
    }
  }
  public void stop() {
  }
  public void close(){
    DriverStation.reportWarning("down--------------(._.)----------------", false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
