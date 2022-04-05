// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;

//import java.util.concurrent.TimeoutException;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveTrain;

public class DriveTurn180CMD extends CommandBase {
  /** Creates a new DriveBack. */
  public final DriveTrain m_ddriveTrain;
  public Timer m_Timer;
  public final double revs = 1.8; 
  public final double secs =2;
  private boolean finished = false;
  public DriveTurn180CMD(DriveTrain drive_subsystem) {
    m_ddriveTrain = drive_subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_ddriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Timer = new Timer();
    m_Timer.reset();
    m_Timer.start();
    finished=false;
    m_ddriveTrain.left1.getEncoder().setPosition(0);
    m_ddriveTrain.right1.getEncoder().setPosition(0);
   }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
 //+ +
 // - +
    if(m_Timer.get() < secs) { 
       m_ddriveTrain.driveposition(revs*m_ddriveTrain.pulses_per_revolution*m_Timer.get()/secs,revs*m_ddriveTrain.pulses_per_revolution*m_Timer.get()/secs); 
      // DriverStation.reportWarning("encoders: right encoder " + m_ddriveTrain.right1.getEncoder().getPosition() + "left encoder " + m_ddriveTrain.left1.getEncoder().getPosition(),false);
      // DriverStation.reportWarning("goal value " + revs*m_ddriveTrain.pulses_per_revolution*m_Timer.get()/secs+ "right" + revs*m_ddriveTrain.pulses_per_revolution*m_Timer.get()/secs,false);
    }
    else{ 
      m_ddriveTrain.drivepower(0, 0); 
      m_Timer.stop();
      finished=true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
