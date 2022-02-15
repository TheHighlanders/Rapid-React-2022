// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.sql.Driver;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrain;

public class driveCMD extends CommandBase {
  /** Creates a new driveCMD. */
  public final DriveTrain m_dDrivetrain;
  public final OI m_OI;

  public driveCMD(DriveTrain drive_subsystem, OI OI_xbox) {
    m_dDrivetrain = drive_subsystem;
    m_OI = OI_xbox;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_dDrivetrain);
    left1.configFactoryDefault();
    right1.configFactoryDefault();
    right1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 1000);
    left1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 1000);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //dead band stuff
    double x = this.m_OI.getXboxLeftX()*26076;
    double y = this.m_OI.getXboxLeftY()*26076;
    double threshold = 0.3;
    float stupid = ControlMode.Velocity/10;
    if (!(Math.abs(y) < threshold) && !(Math.abs(x) < threshold)){
     // x = ((2/(1 + Math.pow(Math.E,(-2*x)))) - 1.0); old code
     left1.set(stupid,x-y);
     right1.set(stupid,y+x);
    }
    else if (Math.abs(y) < threshold){
      left1.set(stupid,x);
      right1.set(stupid,x);
    }
  
    else if (Math.abs(x) < threshold){
      left1.set(stupid,y);
      right1.set(stupid,y);
    }
  }
      //y = ((2/(1 + Math.pow(Math.E,(-2*y)))) - 1.0); old code
      
    // Lex and Iskandar aded Sigmoid curve to the controls

    //x = (1/(1 + Math.pow(Math.E,(-1*x))));

    //x = (x - threshold * Math.signum(x)) / (1 - threshold);
    //y = (y - threshold * Math.signum(y)) / (1 - threshold);
    //m_dDrivetrain.drivepower(x-y, y + x);
    // used to be the code below
    // m_dDrivetrain.drivepower(-this.m_OI.getXboxLeftY(), this.m_OI.getXboxRightY());

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
