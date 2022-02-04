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
  private WPI_TalonSRX DMTR; // Declare motor controllers variables

  public Door() {
    DMTR = new WPI_TalonSRX(Constants.DOORMOTOR);
    DMTR.setNeutralMode(NeutralMode.Coast);

  }

  public void drivePower(double power){
    DMTR.set(power);
    DriverStation.reportWarning("DMTR pow =" + power, false);
  }

  public void up(){
    DMTR.set(ControlMode.Position, -409600/Constants.INCHES_PER_ROTATION);
    DriverStation.reportWarning("Up--------------------------------", false);
  }
  public void stop() {
  }
  public void down(){
    DriverStation.reportWarning("down------------------------------", false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
