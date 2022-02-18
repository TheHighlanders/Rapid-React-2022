// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrain;

public class driveCMD extends CommandBase {
  /** Creates a new driveCMD. */
  public final DriveTrain m_ddriveTrain;
  public final OI m_OI;

  public driveCMD(DriveTrain drive_subsystem, OI OI_xbox) {
    m_ddriveTrain = drive_subsystem;
    m_OI = OI_xbox;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_ddriveTrain);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ddriveTrain.drivepower(this.m_OI.getXboxLeftY(), this.m_OI.getXboxRightY());

    double x = this.m_OI.getXboxLeftX()*2173; // (4096 [encoder units] * 10 [encoder is in 10^{-1} of a second])/(6 [diameter of wheel] * pi [get circumfrence]) = 2172
    double y = this.m_OI.getXboxLeftY()*2173; 
    double threshold = 0.3;
    if (!(Math.abs(y) < threshold) && !(Math.abs(x) < threshold)){
     // x = ((2/(1 + Math.pow(Math.E,(-2*x)))) - 1.0); old code

     m_ddriveTrain.left1.set(ControlMode.Velocity,x-y);
     m_ddriveTrain.right1.set(ControlMode.Velocity,y+x);
    }
    else if (Math.abs(y) < threshold){
      x = (1/(1 + Math.pow(Math.E,(-1*x))));
      m_ddriveTrain.left1.set(ControlMode.Velocity,x);
      m_ddriveTrain.right1.set(ControlMode.Velocity,x);
    }
  
    else if (Math.abs(x) < threshold){
      y = (y - threshold * Math.signum(y)) / (1 - threshold);
      m_ddriveTrain.left1.set(ControlMode.Velocity,y);
      m_ddriveTrain.right1.set(ControlMode.Velocity,y);
    }
  }
      //y = ((2/(1 + Math.pow(Math.E,(-2*y)))) - 1.0); old code
      

    //x = (1/(1 + Math.pow(Math.E,(-1*x))));

    //x = (x - threshold * Math.signum(x)) / (1 - threshold);
    //y = (y - threshold * Math.signum(y)) / (1 - threshold);
    //m_dDrivetrain.drivepower(x-y, y + x);
    // used to be the code below
    // m_dDrivetrain.drivepower(-this.m_OI.getXboxLeftY(), this.m_OI.getXboxRightY());

  // Called once the command ends or is interrupted.

  // Returns true when the command should end.
  @Override
  public void end(boolean interrupted) {}

  public boolean isFinished() {
    return false;
  }
}
