// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


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
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  /* 
  private double transfer_func(double y){
    //https://www.desmos.com/calculator/vk48zqdn3p
    double threshold = 0.15;
    double low_turn_sensitivity = 0.25;
    double high_sensitivity_threshold = 0.5; 
    double low_line=(Math.abs(y)-threshold)/(1-threshold) * Math.signum(y)*low_turn_sensitivity;
    double high_line= 1/(1-high_sensitivity_threshold)*(Math.abs(y)-high_sensitivity_threshold);
    high_line = Math.abs(Math.max(high_line,0));
    y = Math.max(Math.abs(high_line),Math.abs(low_line))*Math.signum(y);
    return y;
  } */
  @Override
  public void execute() {
    //dead band stuff
    double x = this.m_OI.getXboxLeftX();
    double y = this.m_OI.getXboxLeftY();

    double threshold = 0.15;
    
    if (Math.abs(y) < threshold) {
      y = 0;
    }
    else{
      y= (Math.abs(y)-threshold)/(1-threshold) * Math.signum(y);
      // y = ((2/(1 + Math.pow(Math.E,(-2*y)))) - 1.0); // * Math.signum(y);
      
    }
    
    if (Math.abs(x) < threshold){
      x = 0;
    }
    else{
    //  x = transfer_func(x);
      x= (Math.abs(x)-threshold)/(1-threshold) * Math.signum(x);
      // x*=0.5;

      // x = ((2/(1 + Math.pow(Math.E,(-2*x)))) - 1.0); // * Math.signum(x);
      
    }
    // Lex and Iskandar aded Sigmoid curve to the controls

    //x = (1/(1 + Math.pow(Math.E,(-1*x))));

    //x = (x - threshold * Math.signum(x)) / (1 - threshold);
    //y = (y - threshold * Math.signum(y)) / (1 - threshold);
    // x *= 0.5;
    // m_dDrivetrain.drivepower(x-y, y + x);
    m_dDrivetrain.drivespeed(x-y, y + x);
    // used to be the code below
    // m_dDrivetrain.drivepower(-this.m_OI.getXboxLeftY(), this.m_OI.getXboxRightY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
